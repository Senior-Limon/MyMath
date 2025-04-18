package com.example.mymathwithggaek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ItogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_itog)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val finish: Button = findViewById(R.id.finishApp)
        val Ans1: EditText = findViewById(R.id.ans1)
        val Ans2: EditText = findViewById(R.id.ans2)
        val Ans3: EditText = findViewById(R.id.ans3)
        val Ans4: EditText = findViewById(R.id.ans4)
        val Ans5: EditText = findViewById(R.id.ans5)
        val Ans6: EditText = findViewById(R.id.ans6)
        val Ans7: EditText = findViewById(R.id.ans7)
        val Ans8: EditText = findViewById(R.id.ans8)
        val Ans9: EditText = findViewById(R.id.ans9)
        val Ans10: EditText = findViewById(R.id.ans10)
        val Ans11: EditText = findViewById(R.id.ans11)
        val Ans12: EditText = findViewById(R.id.ans12)
        val Ans13: EditText = findViewById(R.id.ans13)
        val Ans14: EditText = findViewById(R.id.ans14)
        val Ans15: EditText = findViewById(R.id.ans15)
        val Ans16: EditText = findViewById(R.id.ans16)
        val Ans17: EditText = findViewById(R.id.ans17)
        val Ans18: EditText = findViewById(R.id.ans18)
        val Ans19: EditText = findViewById(R.id.ans19)
        val back : TextView = findViewById(R.id.backItog)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val intent = Intent(this, GLActivity::class.java)
//для проверки на то проходили этот уровень или нет(обращаемся по ключу и проверяем) по нажатию кнопки
        finish.setOnClickListener {
            val Fix = sharedPreferences.getString("TroobleIt", "")
            if (Fix != "0") {
                if (
                    (Ans1.text.toString().trim() == "238") &&
                    (Ans2.text.toString().trim() == "437")  &&
                    (Ans3.text.toString().trim() == "12") &&
                    (Ans4.text.toString().trim() == "9") &&
                    ((Ans5.text.toString().trim() == "1") ||
                            (Ans5.text.toString().trim() == "3/3"))&&
                    (Ans6.text.toString().trim() == "5/8") &&
                    (Ans7.text.toString().trim() == "6/35")&&
                    ((Ans8.text.toString().trim() == "6.8")||
                        (Ans8.text.toString().trim() == "6,8"))&&
                    ((Ans9.text.toString().trim() == "6.5")||
                            (Ans9.text.toString().trim() == "6,5"))&&
                    ((Ans10.text.toString().trim() == "6.3")||
                            (Ans10.text.toString().trim() == "6,3"))&&
                    (Ans11.text.toString().trim() == "-2")&&
                    (Ans12.text.toString().trim() == "-14")&&
                    (Ans13.text.toString().trim() == "18")&&
                    (Ans14.text.toString().trim() == "3")&&
                    (Ans15.text.toString().trim() == "1")&&
                    (Ans16.text.toString().trim() == "6")&&
                    (Ans17.text.toString().trim() == "5")&&
                    (Ans18.text.toString().trim() == "3")&&
                    (Ans19.text.toString().trim() == "3")
                ) {
                    Toast.makeText(this, "Ты молодец!!!", Toast.LENGTH_SHORT).show()
//записываем 1 для изменения цвета в главной странице
                    val edition = sharedPreferences.edit()
                    edition.putString("Itog", "1")
                    edition.apply()
//увеличение уровня
                    val level = sharedPreferences.getInt("Level", 0)
                    val newLevel = level + 2
                    val editionlevel = sharedPreferences.edit()
                    editionlevel.putInt("Level", newLevel)
                    editionlevel.apply()
//проверка на то проходили ли этот урок
                    val TroobleShootIt = sharedPreferences.edit()
                    TroobleShootIt.putString("TroobleIt", "0")
                    TroobleShootIt.apply()

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
        back.setOnClickListener{
            startActivity(intent)
        }
    }
}

