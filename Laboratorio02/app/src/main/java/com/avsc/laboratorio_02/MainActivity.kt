package com.avsc.laboratorio_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.system.Os.bind
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var textViewBMI: TextView
    private lateinit var resultTextView: TextView
    private lateinit var displayHeight: TextView
    private lateinit var weightEdit: EditText
    private lateinit var heightEdit: EditText
    private lateinit var calculateButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        bind()
        setListener()
    }
    private fun bind(){
        textViewBMI = findViewById(R.id.text_view_bmi)
        weightEdit = findViewById(R.id.weight_text_hint)
        heightEdit = findViewById(R.id.height_text_hint)
        resultTextView = findViewById(R.id.display_weight_text)
        displayHeight = findViewById(R.id.display_height_text)
        calculateButton = findViewById(R.id.btn_calculate)

    }

    private fun setListener() {
        calculateButton.setOnClickListener {
            val lweight = weightEdit.text.toString()
            val lheight = heightEdit.text.toString()

            if(!validateInput(lweight,lheight)){
                clearTextview()

                return@setOnClickListener
            }
           val lbmi = calculateBMI(lweight.toFloat(),lheight.toFloat())
            val bmiToDigits = String.format("%2f",lbmi).toFloat()

            clearFocus()
            displayResult(bmiToDigits)
        }
    }

    private fun validateInput(weight: String?, height: String?):Boolean{
        when{
            weight.isNullOrEmpty() ->{
                Toast.makeText(this, "Weight is empty",Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

    private fun calculateBMI(weight: Float, height: Float): Float{
    return  weight/((height/100)*(height/100))
    }

    private fun displayResult(bmi: Float){
        textViewBMI.text = "(Normal range is 18.5 - 24.99 )"

        var informationResult = ""
        var color = 0

        when{
            bmi<18.5->{
                informationResult = "Underweight"
                color = R.color.under_weight
            }
            bmi in 18.5..24.99->{
                informationResult = "Healthy"
                color = R.color.normal_weight
            }
            bmi in 25.0..29.99->{
                informationResult = "Overweight"
                color = R.color.over_weight
            }
            bmi > 30.00->{
                informationResult = "Obese"
                color = R.color.obese
            }
        }
        resultTextView.text = informationResult

        resultTextView.setTextColor(ContextCompat.getColor(this, color))
    }

        private fun clearFocus(){
            weightEdit.clearFocus()
            heightEdit.clearFocus()
        }
        private fun clearTextview(){
            textViewBMI.text = ""
            resultTextView.text = ""
            displayHeight.text = ""
        }
}
