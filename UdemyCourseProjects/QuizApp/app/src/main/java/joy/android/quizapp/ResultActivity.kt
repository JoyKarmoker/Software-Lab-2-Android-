package joy.android.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 10)

        val tvName:TextView = findViewById(R.id.tv_name)
        val tvScore:TextView = findViewById(R.id.tv_score)
        val btnFinish:Button = findViewById(R.id.btn_finish)

        tvName.text = userName.toString()
        tvScore.text = "Your score is $correctAnswers of $totalQuestion"

        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}