package com.example.mymathwithggaek

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Les1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_les1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val FinishLesson = findViewById<Button>(R.id.Finish)
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        FinishLesson.setOnClickListener {

            Toast.makeText(this, "Молодец", Toast.LENGTH_SHORT).show()
// для изменения цвета кнопки в главном меню
            val edition = sharedPreferences.edit()
            edition.putString("VVEDEN", "1")
            edition.apply()

            val Fix = sharedPreferences.getString("TroobleVV", "")

            if (Fix != "0" ) {
//увеличение уровня
            val level = sharedPreferences.getInt("Level", 0)
            val newLevel = level + 1
            val editionlevel = sharedPreferences.edit()
            editionlevel.putInt("Level", newLevel)
            editionlevel.apply()
//для проверки проходили ли уже этот тест
            val TroobleShootVV = sharedPreferences.edit()
            TroobleShootVV.putString("TroobleVV", "0")
            TroobleShootVV.apply()

            }


            //старутем другую страницу + sound
            val intent = Intent(this, GLActivity::class.java)
            val mediaPlayer = MediaPlayer.create(this, R.raw.tr)
            mediaPlayer.start()
            startActivity(intent)

        }

    }
}