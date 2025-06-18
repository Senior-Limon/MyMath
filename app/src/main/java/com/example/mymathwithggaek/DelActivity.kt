package com.example.mymathwithggaek

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_del)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = Intent(this, GLActivity::class.java)

        val ButYes = findViewById<Button>(R.id.Yes)
        val ButNo = findViewById<Button>(R.id.No)
//        программно меняю цвета

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
//        обработка нажатия на кнопку отказ
        ButNo.setOnClickListener {
            startActivity(intent)
        }
//        обработка нажатия на кнопку соглашения сброса данных
        ButYes.setOnClickListener {
            Toast.makeText(this, "Данные сброшены", Toast.LENGTH_SHORT).show()
//сбрасываем цвет и факт прохождения урока введения
            val editionVV = sharedPreferences.edit()
            editionVV.putString("VVEDEN", "0")
            editionVV.apply()
            val TroobleShootVV = sharedPreferences.edit()
            TroobleShootVV.putString("TroobleVV", "1")
            TroobleShootVV.apply()
//сбрасываем цвет и факт прохождения урока 2
            val editionL2 = sharedPreferences.edit()
            editionL2.putString("L2", "0")
            editionL2.apply()
            val TroobleShootL2 = sharedPreferences.edit()
            TroobleShootL2.putString("TroobleL2", "1")
            TroobleShootL2.apply()
//сбрасываем цвет и факт прохождения урока 3
            val editionL3 = sharedPreferences.edit()
            editionL3.putString("L3", "0")
            editionL3.apply()
            val TroobleShootL3 = sharedPreferences.edit()
            TroobleShootL3.putString("TroobleL3", "1")
            TroobleShootL3.apply()
//сбрасываем цвет и факт прохождения урока 4
            val editionL4 = sharedPreferences.edit()
            editionL4.putString("L4", "0")
            editionL4.apply()
            val TroobleShootL4 = sharedPreferences.edit()
            TroobleShootL4.putString("TroobleL4", "1")
            TroobleShootL4.apply()
//сбрасываем цвет и факт прохождения урока 5
            val editionL5 = sharedPreferences.edit()
            editionL5.putString("L5", "0")
            editionL5.apply()
            val TroobleShootL5 = sharedPreferences.edit()
            TroobleShootL5.putString("TroobleL5", "1")
            TroobleShootL5.apply()
//сбрасываем цвет и факт прохождения урока 6
            val editionL6 = sharedPreferences.edit()
            editionL6.putString("L6", "0")
            editionL6.apply()
            val TroobleShootL6 = sharedPreferences.edit()
            TroobleShootL6.putString("TroobleL6", "1")
            TroobleShootL6.apply()
//сбрасываем цвет и факт прохождения урока 7
            val editionL7 = sharedPreferences.edit()
            editionL7.putString("L7", "0")
            editionL7.apply()
            val TroobleShootL7 = sharedPreferences.edit()
            TroobleShootL7.putString("TroobleL7", "1")
            TroobleShootL7.apply()
//сбрасываем цвет и факт прохождения итогового урока
            val editionItog = sharedPreferences.edit()
            editionItog.putString("Itog", "0")
            editionItog.apply()
            val TroobleShootIt = sharedPreferences.edit()
            TroobleShootIt.putString("TroobleIt", "1")
            TroobleShootIt.apply()
//обнуляем уровень
            val editorName = sharedPreferences.edit()
            editorName.putInt("Level", 0 )
            editorName.apply()

//обнуляем попытки прохождения уроков 2.3.4.5.6.ит.
            val editionPop2 = sharedPreferences.edit()
            editionPop2.putInt("StatistL2", 0)
            editionPop2.apply()

            val editionPop3 = sharedPreferences.edit()
            editionPop3.putInt("StatistL3", 0)
            editionPop3.apply()

            val editionPop4 = sharedPreferences.edit()
            editionPop4.putInt("StatistL4", 0)
            editionPop4.apply()

            val editionPop5 = sharedPreferences.edit()
            editionPop5.putInt("StatistL5", 0)
            editionPop5.apply()

            val editionPop6 = sharedPreferences.edit()
            editionPop6.putInt("StatistL6", 0)
            editionPop6.apply()

            val editionPop7 = sharedPreferences.edit()
            editionPop7.putInt("StatistL7", 0)
            editionPop7.apply()

            val editionPopIt = sharedPreferences.edit()
            editionPopIt.putInt("StatistIt", 0)
            editionPopIt.apply()


//запускаем обновлённую главную страницу
            startActivity(intent)
        }


    }
}