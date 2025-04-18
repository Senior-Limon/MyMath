package com.example.mymathwithggaek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Les6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_les6)
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
        val backl6 : ImageView = findViewById(R.id.backl7)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val intent = Intent(this, GLActivity::class.java)
//для проверки на то проходили этот уровень или нет(обращаемся по ключу и проверяем) по нажатию кнопки
        finish.setOnClickListener {
            val Fix = sharedPreferences.getString("TroobleL6", "")
            if (Fix != "0") {
                if (
                    (Ans1.text.toString().trim() == "-7") &&
                    (Ans2.text.toString().trim() == "-7")  &&
                    (Ans3.text.toString().trim() == "-6") &&
                    (Ans4.text.toString().trim() == "-1") &&
                    (Ans5.text.toString().trim() == "-18")  &&
                    (Ans6.text.toString().trim() == "0")
                    ) {
                    Toast.makeText(this, "Ты молодец!!!", Toast.LENGTH_SHORT).show()
//записываем 1 для изменения цвета в главной странице
                    val edition = sharedPreferences.edit()
                    edition.putString("L6", "1")
                    edition.apply()
//увеличение уровня
                    val level = sharedPreferences.getInt("Level", 0)
                    val newLevel = level + 1
                    val editionlevel = sharedPreferences.edit()
                    editionlevel.putInt("Level", newLevel)
                    editionlevel.apply()
//проверка на то проходили ли этот урок
                    val TroobleShootL6 = sharedPreferences.edit()
                    TroobleShootL6.putString("TroobleL6", "0")
                    TroobleShootL6.apply()

//старутем другую страницу
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Не все ответы верны( попробуй ещё раз", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Вы это уже проходили!!!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
        backl6.setOnClickListener{
            startActivity(intent)
            }
    }
}