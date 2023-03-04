package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var input: TextView = findViewById(R.id.input)
        var output: TextView = findViewById(R.id.output)

        val buttonClear: AppCompatButton = findViewById(R.id.button_Clear)
        buttonClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        val buttonBracketLeft: AppCompatButton = findViewById(R.id.button_Bracket_Left)
       buttonBracketLeft.setOnClickListener {
            input.text = addToInputText("(")
        }

        val buttonBracketRight: AppCompatButton = findViewById(R.id.button_Bracket_Right)
        buttonBracketRight.setOnClickListener {
            input.text = addToInputText(")")
        }

        val button0 : AppCompatButton = findViewById(R.id.button_0)
        button0.setOnClickListener {
            input.text = addToInputText("0")
        }

        val button1 : AppCompatButton = findViewById(R.id.button_1)
        button1.setOnClickListener {
            input.text = addToInputText("1")
        }

        val button2 : AppCompatButton = findViewById(R.id.button_2)
        button2.setOnClickListener {
            input.text = addToInputText("2")
        }

        val button3 : AppCompatButton = findViewById(R.id.button_3)
        button3.setOnClickListener {
            input.text = addToInputText("3")
        }

        val button4 : AppCompatButton = findViewById(R.id.button_4)
        button4.setOnClickListener {
            input.text = addToInputText("4")
        }

        val button5 : AppCompatButton = findViewById(R.id.button_5)
        button5.setOnClickListener {
            input.text = addToInputText("5")
        }

        val button6 : AppCompatButton = findViewById(R.id.button_6)
        button6.setOnClickListener {
            input.text = addToInputText("6")
        }

        val button7 : AppCompatButton = findViewById(R.id.button_7)
        button7.setOnClickListener {
            input.text = addToInputText("7")
        }

        val button8 : AppCompatButton = findViewById(R.id.button_8)
        button8.setOnClickListener {
            input.text = addToInputText("8")
        }

        val button9 : AppCompatButton = findViewById(R.id.button_9)
        button9.setOnClickListener {
            input.text = addToInputText("9")
        }

        val buttonDot : AppCompatButton = findViewById(R.id.button_Dot)
        buttonDot.setOnClickListener {
            input.text = addToInputText(".")
        }

        val buttonDivision : AppCompatButton = findViewById(R.id.button_Division)
        buttonDivision.setOnClickListener {
            input.text = addToInputText("÷")
        }

        val buttonMultiplication : AppCompatButton = findViewById(R.id.button_Multiplication)
        buttonMultiplication.setOnClickListener {
            input.text = addToInputText("×")
        }

        val buttonSubtraction : AppCompatButton = findViewById(R.id.button_Subtraction)
        buttonSubtraction.setOnClickListener {
            input.text = addToInputText("-")
        }

        val buttonAddition : AppCompatButton = findViewById(R.id.button_Addition)
        buttonAddition.setOnClickListener {
            input.text = addToInputText("+")
        }

        val buttonEquals : AppCompatButton = findViewById(R.id.button_Equals)
        buttonEquals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        var input: TextView = findViewById(R.id.input)
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var input: TextView = findViewById(R.id.input)
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()

            if (result.isNaN()) {
                var output: TextView = findViewById(R.id.output)
                //Show error message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                var output: TextView = findViewById(R.id.output)
                //Show result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }

        } catch (e: Exception) {
            var output: TextView = findViewById(R.id.output)
            //Show error message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}