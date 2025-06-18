package com.example.mymathwithggaek

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
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
import androidx.core.widget.doOnTextChanged

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
        val mediaPlayer = MediaPlayer.create(this, R.raw.it)
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        var ans : Int = 0

        val intent = Intent(this, GLActivity::class.java)
//для проверки на то проходили этот уровень или нет(обращаемся по ключу и проверяем) по нажатию кнопки
        finish.setOnClickListener {
            val Fix = sharedPreferences.getString("TroobleIt", "")
            if (Fix != "0") {

//                отслеживание ответов

                if (Ans1.text.toString().trim() == "238") {
                    ans += 1
                }
                else {
                    Ans1.setTextColor(Color.RED)
                }


                if (Ans2.text.toString().trim() == "437") {
                    ans += 1
                }
                else {
                    Ans2.setTextColor(Color.RED)
                }


                if (Ans3.text.toString().trim() == "12") {
                    ans += 1
                }
                else {
                    Ans3.setTextColor(Color.RED)
                }


                if (Ans4.text.toString().trim() == "9") {
                    ans += 1
                }
                else {
                    Ans9.setTextColor(Color.RED)
                }

                if (Ans5.text.toString().trim() == "1" || Ans5.text.toString().trim() == "3/3") {
                    ans += 1
                }
                else {
                    Ans5.setTextColor(Color.RED)
                }


                if (Ans6.text.toString().trim() == "5/8") {
                    ans += 1
                }
                else {
                    Ans6.setTextColor(Color.RED)
                }


                if (Ans7.text.toString().trim() == "6/35") {
                    ans += 1
                }
                else {
                    Ans7.setTextColor(Color.RED)
                }


                if (Ans8.text.toString().trim() == "6.8" || Ans8.text.toString().trim() == "6,8") {
                    ans += 1
                }
                else {
                    Ans8.setTextColor(Color.RED)
                }

                if (Ans9.text.toString().trim() == "6.5" || Ans9.text.toString().trim() == "6,5") {
                    ans += 1
                }
                else {
                    Ans9.setTextColor(Color.RED)
                }


                if (Ans10.text.toString().trim() == "6.3" || Ans10.text.toString().trim() == "6,3") {
                    ans += 1
                }
                else {
                    Ans10.setTextColor(Color.RED)
                }


                if (Ans11.text.toString().trim() == "-2") {
                    ans += 1
                }
                else {
                    Ans11.setTextColor(Color.RED)
                }

                if (Ans12.text.toString().trim() == "-14") {
                    ans += 1
                }
                else {
                    Ans12.setTextColor(Color.RED)
                }


                if (Ans13.text.toString().trim() == "18") {
                    ans += 1
                }
                else {
                    Ans13.setTextColor(Color.RED)
                }


                if (Ans14.text.toString().trim() == "3") {
                    ans += 1
                }
                else {
                    Ans14.setTextColor(Color.RED)
                }


                if (Ans15.text.toString().trim() == "1") {
                    ans += 1
                }
                else {
                    Ans15.setTextColor(Color.RED)
                }

                if (Ans16.text.toString().trim() == "6") {
                    ans += 1
                }
                else {
                    Ans16.setTextColor(Color.RED)
                }


                if (Ans17.text.toString().trim() == "5") {
                    ans += 1
                }
                else {
                    Ans17.setTextColor(Color.RED)
                }


                if (Ans18.text.toString().trim() == "3") {
                    ans += 1
                }
                else {
                    Ans18.setTextColor(Color.RED)
                }


                if (Ans19.text.toString().trim() == "3") {
                    ans += 1
                }
                else {
                    Ans19.setTextColor(Color.RED)
                }

                if (ans > 15) {
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
//увеличение попытки прохождения
                    val Popit = sharedPreferences.getInt("Statist", 0)
                    val Stat = Popit + 1
                    val editionPop = sharedPreferences.edit()
                    editionPop.putInt("Statist", Stat)
                    editionPop.apply()

//старутем другую страницу + sound
                    val mediaPlayer = MediaPlayer.create(this, R.raw.tr)
                    mediaPlayer.start()
                    startActivity(intent)
                }
                else {
//увеличение попытки прохождения
                    val Popit = sharedPreferences.getInt("Statist", 0)
                    val Stat = Popit + 1
                    val editionPop = sharedPreferences.edit()
                    editionPop.putInt("Statist", Stat)
                    editionPop.apply()
//
                    Toast.makeText(this, "Не все ответы верны( попробуй ещё раз", Toast.LENGTH_SHORT).show()
                    // sound
                    val mediaPlayer = MediaPlayer.create(this, R.raw.fl)
                    mediaPlayer.start()
                }
            }
            else {
                Toast.makeText(this, "Вы это уже проходили!!!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
        // возвращение цвета при изменении
        Ans1.doOnTextChanged {text, start, before, count ->
            Ans1.setTextColor(Color.BLACK)
        }

        Ans2.doOnTextChanged {text, start, before, count ->
            Ans2.setTextColor(Color.BLACK)
        }

        Ans3.doOnTextChanged {text, start, before, count ->
            Ans3.setTextColor(Color.BLACK)
        }

        Ans4.doOnTextChanged {text, start, before, count ->
            Ans4.setTextColor(Color.BLACK)
        }

        Ans5.doOnTextChanged {text, start, before, count ->
            Ans5.setTextColor(Color.BLACK)
        }

        Ans6.doOnTextChanged {text, start, before, count ->
            Ans6.setTextColor(Color.BLACK)
        }

        Ans7.doOnTextChanged {text, start, before, count ->
            Ans7.setTextColor(Color.BLACK)
        }

        Ans8.doOnTextChanged {text, start, before, count ->
            Ans8.setTextColor(Color.BLACK)
        }

        Ans9.doOnTextChanged {text, start, before, count ->
            Ans9.setTextColor(Color.BLACK)
        }

        Ans10.doOnTextChanged {text, start, before, count ->
            Ans10.setTextColor(Color.BLACK)
        }

        Ans11.doOnTextChanged {text, start, before, count ->
            Ans11.setTextColor(Color.BLACK)
        }

        Ans12.doOnTextChanged {text, start, before, count ->
            Ans12.setTextColor(Color.BLACK)
        }

        Ans13.doOnTextChanged {text, start, before, count ->
            Ans13.setTextColor(Color.BLACK)
        }
        Ans14.doOnTextChanged {text, start, before, count ->
            Ans14.setTextColor(Color.BLACK)
        }

        Ans15.doOnTextChanged {text, start, before, count ->
            Ans15.setTextColor(Color.BLACK)
        }

        Ans16.doOnTextChanged {text, start, before, count ->
            Ans16.setTextColor(Color.BLACK)
        }

        Ans17.doOnTextChanged {text, start, before, count ->
            Ans17.setTextColor(Color.BLACK)
        }

        Ans18.doOnTextChanged {text, start, before, count ->
            Ans18.setTextColor(Color.BLACK)
        }

        Ans19.doOnTextChanged {text, start, before, count ->
            Ans19.setTextColor(Color.BLACK)
        }
//        конец

        back.setOnClickListener{
            startActivity(intent)
        }
    }
}

