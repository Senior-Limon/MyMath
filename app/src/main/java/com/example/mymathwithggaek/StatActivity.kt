package com.example.mymathwithggaek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_stat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val text1 = findViewById<TextView>(R.id.textView1)
        val text2 = findViewById<TextView>(R.id.textView2)
        val text3 = findViewById<TextView>(R.id.textView3)
        val text4 = findViewById<TextView>(R.id.textView4)
        val text5 = findViewById<TextView>(R.id.textView5)
        val text6 = findViewById<TextView>(R.id.textView6)
        val text7 = findViewById<TextView>(R.id.textView7)
        val but = findViewById<Button>(R.id.buttonback)

        but.setOnClickListener {
            val intent = Intent(this, GLActivity::class.java)
            startActivity(intent)
        }

        val T1S = sharedPreferences.getInt("StatistL2", 0)
        text1.text = "Попыток на урок 1: $T1S"

        val T2S = sharedPreferences.getInt("StatistL3", 0)
        text2.text = "Попыток на урок 2: $T2S"

        val T3S = sharedPreferences.getInt("StatistL4", 0)
        text3.text = "Попыток на урок 3: $T3S"

        val T4S = sharedPreferences.getInt("StatistL5", 0)
        text4.text = "Попыток на урок 4: $T4S"

        val T5S = sharedPreferences.getInt("StatistL6", 0)
        text5.text = "Попыток на урок 5: $T5S"

        val T6S = sharedPreferences.getInt("StatistL7", 0)
        text6.text = "Попыток на урок 6: $T6S"

        val T8S = sharedPreferences.getInt("StatistIt", 0)
        text7.text = "Попыток на итоговый урок: $T8S"


    }
}