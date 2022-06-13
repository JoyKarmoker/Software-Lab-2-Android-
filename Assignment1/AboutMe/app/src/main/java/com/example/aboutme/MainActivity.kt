package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneButton = findViewById<Button>(R.id.done_button)
        val nickNameText = findViewById<TextView>(R.id.nickname_text)
        val nicknameEdit = findViewById<TextView>(R.id.nickname_edit)

        doneButton.setOnClickListener{v ->
            nickNameText.text = nicknameEdit.text
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nickNameText.visibility = View.VISIBLE

            //Hide The Keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(v.windowToken, 0)

        }



    }
}