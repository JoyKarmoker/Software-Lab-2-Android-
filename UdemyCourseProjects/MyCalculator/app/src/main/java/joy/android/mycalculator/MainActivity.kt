package joy.android.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    private var tvPreviousInput: TextView? = null
    private var isDotPresent: Boolean = false
    private var isLastInputDigit: Boolean = false
    private var isClear: Boolean = true
    private var isResultGenerated: Boolean = false
    private var isLastInputOperator: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
        tvPreviousInput = findViewById(R.id.tvPreviousInput)
    }

    fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        isLastInputDigit = true
        isClear = false
        isLastInputOperator = false
        isResultGenerated = false
    }

    fun onClear(view: View) {
        if( isResultGenerated)
        {
            tvPreviousInput?.text = tvInput?.text
        }
        tvInput?.text = ""
        isLastInputDigit = false
        isDotPresent = false
        isClear = true
        isLastInputOperator = false
    }

    fun onDot(view: View) {
        if (isLastInputDigit && !isDotPresent) {
            tvInput?.append(".")
            isDotPresent = true
            isLastInputDigit = false
            isClear = false
            isLastInputOperator = false
            isResultGenerated = false
        }
    }

    fun onOperator(view: View) {
        var operator = (view as Button).text
        tvInput?.text?.let {
            if (isClear && (operator.toString() == "-") || (!isOperatorAdded(it.toString())) && isLastInputDigit) {
                tvInput?.append(operator)
                isLastInputOperator = true
                isDotPresent = false
                isLastInputDigit = false
                isClear = false
                isResultGenerated = false
            } else if (isLastInputOperator && (operator.toString() == "-")) {
                tvInput?.append("-")
                isLastInputOperator = false
                isDotPresent = false
                isLastInputDigit = false
                isClear = false
                isResultGenerated = false
            } else if (isLastInputDigit) {
                onEqual(view)
                tvPreviousInput?.text = tvInput?.text
                tvInput?.append(operator)
                isLastInputOperator = true
                isDotPresent = false
                isLastInputDigit = false
                isClear = false
                isResultGenerated = false
            }


        }
    }

    /*fun onOperator(view:View)
    {
        var buttonText = (view as Button).text
        tvInput?.text?.let {
            if(canOperatorBeAdded(it.toString(), buttonText.toString())){
                tvInput?.append(buttonText)
                isLastInputDigit = false
                isDotPresent = false
            }
        }
    }*/

    private fun isOperatorAdded(textViewValue: String): Boolean {
        if (textViewValue.startsWith("-")) {
            val textViewValueAfterRemovingMinus: String = textViewValue.substring(1)

            return textViewValueAfterRemovingMinus.contains("+") || textViewValueAfterRemovingMinus.contains("-") ||
                    textViewValueAfterRemovingMinus.contains(
                        "*"
                    ) || textViewValueAfterRemovingMinus.contains("/")
        }

        return (textViewValue.contains("+") || textViewValue.contains("-") || textViewValue.contains("*") || textViewValue.contains("/"))

    }

    /*private fun canOperatorBeAdded(textViewValue:String, operatorName:String) : Boolean
    {
        return isLastInputDigit || (isClear && operatorName == "-")
    }*/

    /**
     * Calculate the output using Exp4j
     */
    fun onEqual(view: View) {
        // If the last input is a number only, solution can be found.
        if (isLastInputDigit) {
            // Read the expression
            val txt = tvInput?.text.toString()
            // Create an Expression (A class from exp4j library)
            val expression = ExpressionBuilder(txt).build()
            try {
                // Calculate the result and display
                val result = expression.evaluate()
                val round = String.format("%.4f", result)
                tvPreviousInput?.text = tvInput?.text
                tvInput?.text = round
                isDotPresent = true // Result contains a dot
                isClear = false
                isLastInputOperator = false
                isLastInputDigit = true
                isResultGenerated = true
            } catch (ex: ArithmeticException) {
                // Display an error message
                tvInput?.text = "Error"
                isLastInputDigit = false
                isClear = false
                isLastInputOperator = false
                isResultGenerated = false
            }
        }
    }
}
