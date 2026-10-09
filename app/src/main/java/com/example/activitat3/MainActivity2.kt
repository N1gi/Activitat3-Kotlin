package com.example.activitat3

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView
import androidx.core.graphics.toColorInt

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("DefaultLocale", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resultat = intent.getDoubleExtra("resultat", 0.0)
        val text1: TextView=findViewById(R.id.text1)
        val text2: TextView=findViewById(R.id.text2)
        val num: TextView=findViewById(R.id.num)
        val recalcular : MaterialCardView=findViewById(R.id.recarcular)

        num.text = String.format("%.2f", resultat)
        when {
            resultat < 18.5 -> {
                text1.text = "BAIX PES"
                text1.setTextColor(Color.BLUE)
                text2.text = "Baix pes"
            }

            resultat < 25 -> {
                text1.text = "NORMAL"
                text1.setTextColor(Color.GREEN)
                text2.text = "Normal"
            }

            resultat < 30 -> {
                text1.text = "SOBREPÈS"
                text1.setTextColor("#F59E0B".toColorInt())
                text2.text = "Sobrepès"
            }

            else -> {
                text1.text = "OBESITAT"
                text1.setTextColor(Color.RED)
                text2.text = "Obesitat"
            }
        }

        recalcular.setOnClickListener {
            finish()
        }
    }

}