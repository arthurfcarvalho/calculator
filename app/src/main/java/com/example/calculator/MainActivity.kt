package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var display: TextView
    private var currentNumber = ""
    private var firstNumber = ""
    private var operator = ""
    private var result = 0.0
    private var justShowedResult = false
    private var isOperatorSelected = false  // Indica se um operador foi selecionado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        // Lista de botões
        val buttons = listOf(
            R.id.button_zero, R.id.button_one, R.id.button_two, R.id.button_three,
            R.id.button_four, R.id.button_five, R.id.button_six, R.id.button_seven,
            R.id.button_eight, R.id.button_nine, R.id.button_plus, R.id.button_minus,
            R.id.button_multiply, R.id.button_divide, R.id.button_clear,
            R.id.button_plusminus, R.id.button_percentage, R.id.button_comma,
            R.id.button_result
        )

        // Configurar listeners para os botões
        buttons.forEach { id ->
            findViewById<Button>(id).setOnClickListener { onButtonClick(it as Button) }
        }
    }

    private fun onButtonClick(button: Button) {
        when (val text = button.text.toString()) {
            "C" -> clear()
            "=" -> calculateResult()
            "+", "-", "X", "/" -> setOperator(text)
            "+/-" -> toggleSign()
            "%" -> calculatePercentage()
            "." -> appendDecimalPoint()
            else -> appendNumber(text)
        }
    }

    private fun appendNumber(number: String) {
        if (isOperatorSelected && !justShowedResult) {
            // Se um operador foi selecionado, continue adicionando ao display sem apagar
            currentNumber = number
            display.text = "$firstNumber $operator $currentNumber" // Mantém o operador no display
            isOperatorSelected = false
        } else {
            currentNumber += number
            justShowedResult = false
            display.text = display.text.toString() + number
        }
    }

    private fun appendDecimalPoint() {
        if (!currentNumber.contains(".")) {  // Permite apenas um ponto decimal
            currentNumber += if (currentNumber.isEmpty()) "0." else "."
            display.text = "$firstNumber $operator $currentNumber"
        }
    }

    private fun setOperator(op: String) {
        if (currentNumber.isNotEmpty()) {
            if (firstNumber.isEmpty()) {
                firstNumber = currentNumber
            } else if (!isOperatorSelected) {
                calculateResult()
                firstNumber = result.toString()
            }
            operator = op
            isOperatorSelected = true
            justShowedResult = false
            display.text = "$firstNumber $operator"  // Mostra o operador no display
        }
    }

    private fun calculateResult() {
        if (currentNumber.isNotEmpty() && firstNumber.isNotEmpty()) {
            val num1 = firstNumber.toDoubleOrNull() ?: 0.0
            val num2 = currentNumber.toDoubleOrNull() ?: 0.0
            result = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "X" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> 0.0
            }

            if(result.isNaN()){
                display.text = "Erro"
                return
            } else {
                firstNumber = result.toString()
                display.text = firstNumber
                currentNumber = firstNumber
                operator = ""
                isOperatorSelected = true
                justShowedResult = true;
            }
        }
    }

    private fun clear() {
        firstNumber = ""
        currentNumber = ""
        operator = ""
        result = 0.0
        display.text = "0"
        isOperatorSelected = false
    }

    private fun toggleSign() {
        if (currentNumber.isNotEmpty()) {
            currentNumber = if (currentNumber.startsWith("-")) {
                currentNumber.substring(1)
            } else {
                "-$currentNumber"
            }
            display.text = "$firstNumber $operator $currentNumber"
        }
    }

    private fun calculatePercentage() {
        if (currentNumber.isNotEmpty()) {
            val num = currentNumber.toDoubleOrNull() ?: 0.0
            currentNumber = (num / 100).toString()
            display.text = "$firstNumber $operator $currentNumber"
        }
    }
}