package joy.android.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var datePickerBtn = findViewById<Button>(R.id.btnDatePicker)

        datePickerBtn.setOnClickListener {
                View->clickDatePicker(View)
        }
    }

    fun clickDatePicker(view: View)
    {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)
        val tvSelectedDateInMinutes  =findViewById<TextView>(R.id.tvSelectedDateInMinutes)

        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                //Toast.makeText(this, "The Choosen year is $selectedYear month is $selectedMonth day is $selectedDayOfMonth",
                    //Toast.LENGTH_LONG).show()
                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                tvSelectedDate.text = selectedDate
                var sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val formatedDate = sdf.parse(selectedDate)
                val selectedDateInMinutes = formatedDate!!.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDate.time / 60000
                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                tvSelectedDateInMinutes.text = differenceInMinutes.toString()

            }, year, month, day)
        dpd.datePicker.maxDate = Date().time - 86400000
        dpd.show()
    }
}