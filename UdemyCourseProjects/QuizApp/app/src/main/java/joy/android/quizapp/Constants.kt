package joy.android.quizapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWERS:String = "Correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val questionOne = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Uruguay", "Bolivia", "Ecuador",
            1
        )
        questionList.add(questionOne)

        val questionTwo = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "UK", "Austria", "USA", "Australia",
            4
        )
        questionList.add(questionTwo)

        val questionThree = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Germany", "Spain", "Belgium", "Italy",
            3
        )
        questionList.add(questionThree)

        val questionFour = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina", "Ghana", "Brazil", "Nigeria",
            3
        )
        questionList.add(questionFour)

        val questionFive = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Switzerland", "Denmark", "Norway", "Qatar",
            2
        )
        questionList.add(questionFive)

        val questionSix = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Fiji", "Tuvalu", "Tonga", "Vanuatu",
            1
        )
        questionList.add(questionSix)

        val questionSeven = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Belgium", "Germany", "Romania", "Poland",
            2
        )
        questionList.add(questionSeven)

        val questionEight = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Bangladesh", "India", "Sri lanka", "Pakistan",
            2
        )
        questionList.add(questionEight)

        val questionNine = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Iran", "UAE", "Qatar", "Kuwait",
            4
        )
        questionList.add(questionNine)

        val questionTen = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Austria", "Australia", "New zealand", "UK",
            3
        )
        questionList.add(questionTen)

        return questionList
    }
}