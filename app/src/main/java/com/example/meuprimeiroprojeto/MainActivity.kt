package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btncalcular: Button = findViewById(R.id.btncalcular)
        val edtPeso: EditText = findViewById(R.id.editText_peso)
        val edtAltura: EditText = findViewById(R.id.editText_altura)


        btncalcular.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val alturaFinal: Float = altura * altura
                val Result: Float = peso / alturaFinal


                val intent = Intent(this, resultActivity::class.java)

                    .apply {
                        putExtra("EXTRA_RESULT", Result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "preencher todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


