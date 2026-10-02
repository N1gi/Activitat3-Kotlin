package com.example.activitat3

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    var home_selected: Boolean=false
    var dona_selected: Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var card_home: MaterialCardView=findViewById<MaterialCardView>(R.id.seleccio_home)
        val card_dona=findViewById<MaterialCardView>(R.id.seleccio_dona)

        card_home.setOnClickListener {
            card_home.setCardBackgroundColor(Color.BLUE)
            card_dona.setCardBackgroundColor(Color.WHITE)
            home_selected=true
            dona_selected=false
        }
        card_dona.setOnClickListener {
            card_dona.setCardBackgroundColor(Color.BLUE)
            card_home.setCardBackgroundColor(Color.WHITE)
            dona_selected=true
            home_selected=false
        }

    }

}