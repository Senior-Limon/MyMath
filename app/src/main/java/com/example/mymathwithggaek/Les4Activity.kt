package com.example.mymathwithggaek

import android.content.Intent
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

class Les4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_les4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val finish: Button = findViewById(R.id.finish)
        val Ans1: EditText = findViewById(R.id.Ans1)
        val Ans2: EditText = findViewById(R.id.Ans2)
        val Ans3: EditText = findViewById(R.id.Ans3)
        val Ans4: EditText = findViewById(R.id.Ans4)
        val Ans5: EditText = findViewById(R.id.Ans5)
        val Ans6: EditText = findViewById(R.id.Ans6)
        val backl4 : ImageView = findViewById(R.id.backl4)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val intent = Intent(this, GLActivity::class.java)
//для проверки на то проходили этот уровень или нет(обращаемся по ключу и проверяем) по нажатию
        finish.setOnClickListener {
            val Fix = sharedPreferences.getString("TroobleL4", "")
            if (Fix != "0") {
                if (
                    ((Ans1.text.toString().trim() == "3/6") ||
                            (Ans1.text.toString().trim() == "1/2")) &&
                    (Ans2.text.toString().trim() == "9/10") &&
                    (Ans3.text.toString().trim() == "3/8") &&
                    ((Ans4.text.toString().trim() == "7/14") ||
                            (Ans4.text.toString().trim() == "1/2")) &&
                    ((Ans5.text.toString().trim() == "6/20") ||
                            (Ans5.text.toString().trim() == "3/10")) &&
                    ((Ans6.text.toString().trim() == "5/10") ||
                            (Ans6.text.toString().trim() == "1/2"))
                    ) {
                    Toast.makeText(this, "Ты молодец!!!", Toast.LENGTH_SHORT).show()
//записываем 1 для изменения цвета в главной странице
                    val edition = sharedPreferences.edit()
                    edition.putString("L4", "1")
                    edition.apply()
//увеличение уровня
                    val level = sharedPreferences.getInt("Level", 0)
                    val newLevel = level + 1
                    val editionlevel = sharedPreferences.edit()
                    editionlevel.putInt("Level", newLevel)
                    editionlevel.apply()
//проверка на то проходили ли этот урок
                    val TroobleShootL4 = sharedPreferences.edit()
                    TroobleShootL4.putString("TroobleL4", "0")
                    TroobleShootL4.apply()

//старутем другую страницу + sound
                    val mediaPlayer = MediaPlayer.create(this, R.raw.tr)
                    mediaPlayer.start()
                    startActivity(intent)
                }
                //  вывод сообщения о том что не все ответы верны
                else {
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
        backl4.setOnClickListener{
            startActivity(intent)
            }
    }
}