package com.example.mymathwithggaek

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Les2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_les2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //создаём переменные для обработки значений и нажатия на кнопку
        val finish: Button = findViewById(R.id.finishBt)
        val Answer1: EditText = findViewById(R.id.V1)
        val Answer2: EditText = findViewById(R.id.V2)
        val Answer3: EditText = findViewById(R.id.V3)
        val Answer4: EditText = findViewById(R.id.V4)
        val backl2 : ImageView = findViewById(R.id.backl2)
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

//создаю интент для главного окна
        val intent = Intent(this, GLActivity::class.java)
//обработка нажатия на кнопку
        finish.setOnClickListener {


//для проверки на то проходили этот уровень или нет(обращаемся по ключу и проверяем)
            val Fix = sharedPreferences.getString("TroobleL2", "")
            if (Fix != "0") {
                if (
                    (Answer1.text.toString().trim() == "120") &&
                    (Answer2.text.toString().trim() == "0") &&
                    (Answer3.text.toString().trim() == "27") &&
                    (Answer4.text.toString().trim() == "42")
                    ) {
                    Toast.makeText(this, "Ты молодец!!!", Toast.LENGTH_SHORT).show()
//записываем 1 для изменения цвета в главной странице
                    val edition = sharedPreferences.edit()
                    edition.putString("L2", "1")
                    edition.apply()
//увеличение уровня
                    val level = sharedPreferences.getInt("Level", 0)
                    val newLevel = level + 1
                    val editionlevel = sharedPreferences.edit()
                    editionlevel.putInt("Level", newLevel)
                    editionlevel.apply()
//записываем данные для будующей проверки на то проходили ли этот урок
                    val TroobleShootL2 = sharedPreferences.edit()
                    TroobleShootL2.putString("TroobleL2", "0")
                    TroobleShootL2.apply()
//увеличение попытки прохождения
                    val Popit = sharedPreferences.getInt("StatistL2", 0)
                    val Stat = Popit + 1
                    val editionPop = sharedPreferences.edit()
                    editionPop.putInt("StatistL2", Stat)
                    editionPop.apply()
//старутем другую страницу + sound
                    val mediaPlayer = MediaPlayer.create(this, R.raw.tr)
                    mediaPlayer.start()
                    startActivity(intent)
                }
//  вывод сообщения о том что не все ответы верны
                else {
//увеличение попытки прохождения
                    val Popit = sharedPreferences.getInt("StatistL2", 0)
                    val Stat = Popit + 1
                    val editionPop = sharedPreferences.edit()
                    editionPop.putInt("StatistL2", Stat)
                    editionPop.apply()
//
                    Toast.makeText(this, "Не все ответы верны(", Toast.LENGTH_SHORT).show()
                    // sound
                    val mediaPlayer = MediaPlayer.create(this, R.raw.fl)
                    mediaPlayer.start()
                }
            }
//            вывод сообщения о том что этот урок уже проходили
            else {
                Toast.makeText(this, "Вы это уже проходили", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
//обработка нжатия кнопки на главную
        backl2.setOnClickListener {
            startActivity(intent)
        }

    }
}