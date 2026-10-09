package com.example.activitat3

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
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
    var homeSelected: Boolean=false
    var donaSelected: Boolean=false
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

        val cardHome: MaterialCardView=findViewById(R.id.seleccio_home)
        val cardDona=findViewById<MaterialCardView>(R.id.seleccio_dona)
        val slider: Slider = findViewById(R.id.slider)
        val polzades : TextView = findViewById(R.id.polzades)
        val nPes: TextView = findViewById(R.id.nPes)
        val nEdat: TextView = findViewById(R.id.nEdat)
        val rmvPes: MaterialButton = findViewById(R.id.menys)
        val addPes: MaterialButton = findViewById(R.id.mes)
        val rmvEdat: MaterialButton = findViewById(R.id.menys2)
        val addEdat: MaterialButton = findViewById(R.id.mes2)
        val calcular: MaterialCardView=findViewById(R.id.carcular)

        cardHome.setOnClickListener {
            cardHome.setCardBackgroundColor("#A770B2".toColorInt())
            cardDona.setCardBackgroundColor(Color.TRANSPARENT)
            homeSelected=true
            donaSelected=false
        }
        cardDona.setOnClickListener {
            cardDona.setCardBackgroundColor("#A770B2".toColorInt())
            cardHome.setCardBackgroundColor(Color.TRANSPARENT)
            donaSelected = true
            homeSelected = false
        }

        slider.addOnChangeListener { _, value, _ ->
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
        calcular.setOnClickListener {
            val pes = nPes.text.toString().toDouble()
            val alcada = polzades.text.toString().toDouble()
            val resultat = (pes * 703) / (alcada * alcada)

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("resultat", resultat)
            startActivity(intent)
        }

    }

}