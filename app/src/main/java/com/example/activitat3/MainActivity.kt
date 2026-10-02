package com.example.activitat3

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.slider.Slider
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {
    var home_selected: Boolean=false
    var dona_selected: Boolean=false
    @SuppressLint("SetTextI18n")
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
        var slider: Slider = findViewById(R.id.slider)
        var polzades : TextView = findViewById(R.id.polzades)
        val nPes: TextView = findViewById(R.id.nPes)
        val nEdat: TextView = findViewById(R.id.nEdat)
        var rmvPes: MaterialButton = findViewById<MaterialButton>(R.id.menys)
        var addPes: MaterialButton = findViewById<MaterialButton>(R.id.mes)
        var rmvEdat: MaterialButton = findViewById<MaterialButton>(R.id.menys2)
        var addEdat: MaterialButton = findViewById<MaterialButton>(R.id.mes2)

        card_home.setOnClickListener {
            card_home.setCardBackgroundColor("#A770B2".toColorInt())
            card_dona.setCardBackgroundColor(Color.TRANSPARENT)
            home_selected=true
            dona_selected=false
        }
        card_dona.setOnClickListener {
            card_dona.setCardBackgroundColor("#A770B2".toColorInt())
            card_home.setCardBackgroundColor(Color.TRANSPARENT)
            dona_selected = true
            home_selected = false
        }

        slider.addOnChangeListener { slider, value, fromUser ->
            val num = (value * 100).toInt()
            polzades.text = num.toString()
        }

        rmvPes.setOnClickListener {
            val pes = nPes.text.toString().toInt()

            if (pes > 0) {
                nPes.text = (pes - 1).toString()
            }
        }

        addPes.setOnClickListener {
            val pes = nPes.text.toString().toInt()

            nPes.text = (pes + 1).toString()
        }

        rmvEdat.setOnClickListener {
            val edat = nEdat.text.toString().toInt()

            if (edat > 0) {
                nEdat.text = (edat - 1).toString()
            }
        }

        addEdat.setOnClickListener {
            val edat = nEdat.text.toString().toInt()

            if (edat < 100) {
                nEdat.text = (edat + 1).toString()
            }
        }
    }

}