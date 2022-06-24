package joy.udemylearn.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickbtn = findViewById<Button>(R.id.mybutton)
        val name = findViewById<TextView>(R.id.name)
        var count = 0;
        clickbtn.setOnClickListener{
            count += 1
            name.text = count.toString()
            Toast.makeText(this, "Hey Joy", Toast.LENGTH_LONG).show()
        }
    }
}