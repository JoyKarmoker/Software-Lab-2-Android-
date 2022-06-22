/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>
    )

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (or better yet, not define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "What is the capital of Bangladesh?",
            answers = listOf("Dhaka", "Khulna", "Natore", "Rajshahi")
        ),
        Question(
            text = "What is the capital of London",
            answers = listOf("England", "Australia", "Bangladesh", "India")
        ),
        Question(
            text = "What is the capital of Pakistan?",
            answers = listOf("Islamabad", "Karachi", "Lahore", "Peshawar")
        ),
        Question(
            text = "What is the best food?",
            answers = listOf("Vat", "Mach", "Dal", "Sobji")
        ),
        Question(
            text = "Who is the president of Bangladesh?",
            answers = listOf("I", "You", "Someone else", "I do not know")
        ),
        Question(
            text = "Which civilization is the oldest?",
            answers = listOf("Greek", "Haroppa", "Babiliyon", "Mesopotemia")
        ),
        Question(
            text = "Who takes our Soft Dev III course?",
            answers = listOf("Faruqe Sir", "Somlal Sir", "Asif Zaman Sir", "BKP Sir")
        ),
        Question(
            text = "x = (n-1) | In which side it is shifted according to DSP?",
            answers = listOf(
                "Right Shifted",
                "Left Shifted",
                "Shift Bolte Kichu Nai",
                "Not Shifted"
            )
        ),
        Question(
            text = "Who created Kotlin?",
            answers = listOf("JetBrains", "Google", "Facebook", "Microsoft")
        ),
        Question(
            text = "What day is today",
            answers = listOf("Saturday", "Sunday", "Monday", "Funday")
        ),
        Question(
            text = "What is the current version of web",
            answers = listOf("1", "2", "3", "4")
        ),
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false
        )

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController()
                            .navigate(R.id.action_gameFragment_to_gameWonFragment)
                    }
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment3)
                }
            }
        }
        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestions)
    }
}
