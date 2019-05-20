package com.example.hp.kotlin.CalculatorApp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.hp.kotlin.R
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {


    var firstNumber = "0";
    var op = "*";
    var isOptSet = false;
    var secondNumber = "0";
    var finalNumber:Double?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun buNumberEvent(view: View) {
        val buttonNumber = view as Button
        var buttonClickValue: String = etShowNumber.text.toString()
        when (buttonNumber.id) {
            bu0.id -> {
                buttonClickValue += "0";
            }

            bu1.id -> {
                buttonClickValue += "1"
            }

            bu2.id -> {
                buttonClickValue += "2"
            }

            bu3.id -> {
                buttonClickValue += "3"
            }

            bu4.id -> {
                buttonClickValue += "4"
            }

            bu5.id -> {
                buttonClickValue += "5"
            }

            bu6.id -> {
                buttonClickValue += "6"
            }

            bu7.id -> {
                buttonClickValue += "7"
            }

            bu8.id -> {
                buttonClickValue += "8"
            }
            bu9.id -> {
                buttonClickValue += "9"
            }

            buDot.id -> {
                buttonClickValue += ""
            }
        }
        etShowNumber.setText(buttonClickValue)
        firstNumber = buttonClickValue;

    }


    fun buOpEvent(view: View) {
        isOptSet = true;
        val buSelect = view as Button
        when (buSelect.id) {
            buMul.id -> {
                op="*";
                etShowNumber.setText("")
            }
            buDiv.id -> {
                op="/";
                etShowNumber.setText("")
            }
            buSub.id -> {
                op="-";
                etShowNumber.setText("")
            }
            buSum.id -> {
                op="+";
                etShowNumber.setText("")
            }

        }
    }

    fun buClean(view: View) {
        etShowNumber.setText("")
    }

    fun buEqualEvent(view: View) {
        secondNumber = etShowNumber.text.toString()
        when(op){
            "*"->{
          finalNumber = firstNumber.toDouble() * secondNumber.toDouble()
            }

            "/"->{
                finalNumber = firstNumber.toDouble() / secondNumber.toDouble()
            }

            "+"->{
                finalNumber = firstNumber.toDouble() + secondNumber.toDouble()
            }

            "-"->{
                finalNumber = firstNumber.toDouble() - secondNumber.toDouble()
            }
        }

        etShowNumber.setText(finalNumber.toString())
    }


}