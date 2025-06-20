package com.example.mymathwithggaek

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_glactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val textV7 = findViewById<TextView>(R.id.textV7)
        val LevelV = findViewById<TextView>(R.id.Level)
        val editName = findViewById<ImageView>(R.id.imageView)
        val ButVved = findViewById<Button>(R.id.buttonVved)
        val ButUM = findViewById<Button>(R.id.buttonUM)
        val ButDel = findViewById<Button>(R.id.buttonDel)
        val ButDr = findViewById<Button>(R.id.buttonDrob)
        val ButDdro = findViewById<Button>(R.id.buttonDdro)
        val ButOtr = findViewById<Button>(R.id.buttonOt)
        val ButUr = findViewById<Button>(R.id.buttonUrv)
        val ButIt = findViewById<Button>(R.id.buttonItog)
        val info = findViewById<ImageView>(R.id.info)
        val delet = findViewById<ImageView>(R.id.delete)
        val sslk = findViewById<TextView>(R.id.textView9)
        val ButST = findViewById<Button>(R.id.buttonStatis)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)


//        алгорит перехода на страницу регистрации если пользователь зашел впервые
        //        создание интента для перехода на другую старницу
        val intent = Intent(this, MainActivity::class.java)
//    для работы с данными    val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
//    вызов данных по ключу   val value = sharedPreferences.getString("name", "Ошибка") name - ключ

        val value = sharedPreferences.getString("name", "")
        if (value == "")
            startActivity(intent)





// проверяем нужно ли красить кнопки и цвета текста
        val Vved_pro = sharedPreferences.getString("VVEDEN", "Ошибка")
        if (Vved_pro == "1") {
            ButVved.setBackgroundColor(Color.GREEN)
            ButVved.setTextColor(Color.BLACK)
        }

        val L2 = sharedPreferences.getString("L2", "Ошибка")
        if (L2 == "1") {
            ButUM.setBackgroundColor(Color.GREEN)
            ButUM.setTextColor(Color.BLACK)
        }

        val L3 = sharedPreferences.getString("L3", "Ошибка")
        if (L3 == "1") {
            ButDel.setBackgroundColor(Color.GREEN)
            ButDel.setTextColor(Color.BLACK)
        }

        val L4 = sharedPreferences.getString("L4", "Ошибка")
        if (L4 == "1") {
            ButDr.setBackgroundColor(Color.GREEN)
            ButDr.setTextColor(Color.BLACK)
        }

        val L5 = sharedPreferences.getString("L5", "Ошибка")
        if (L5 == "1") {
            ButDdro.setBackgroundColor(Color.GREEN)
            ButDdro.setTextColor(Color.BLACK)
        }

        val L6 = sharedPreferences.getString("L6", "Ошибка")
        if (L6 == "1") {
            ButOtr.setBackgroundColor(Color.GREEN)
            ButOtr.setTextColor(Color.BLACK)
        }

        val L7 = sharedPreferences.getString("L7", "Ошибка")
        if (L7 == "1") {
            ButUr.setBackgroundColor(Color.GREEN)
            ButUr.setTextColor(Color.BLACK)
        }
        val Itog = sharedPreferences.getString("Itog", "Ошибка")
        if (Itog == "1") {
            ButIt.setBackgroundColor(Color.GREEN)
            ButIt.setTextColor(Color.BLACK)
        }
//изменение цвета закончилось


// отображение информации
        info.setOnClickListener {
            Toast.makeText(this, "Made from Malashenko Misha and  " +
                    "GGAEK prodaction", Toast.LENGTH_LONG).show()
        }




        editName.setOnClickListener{
// если пользователь захочет изменить имя
            val intent = Intent(this, MainActivity::class.java)
//записываем по ключу 1 для проверки на желание изменить имя в активити майн
            val edition = sharedPreferences.edit()
            edition.putString("EditName", "1")
            edition.apply()
//обнуляем имя по ключу
            val NameEdition = sharedPreferences.edit()
            NameEdition.putString("name", "")
            NameEdition.apply()
//запуск главной активити
            startActivity(intent)


        }

        ButVved.setOnClickListener {
//запуск старницы введения
            val intentL1 = Intent(this, Les1Activity::class.java)
            startActivity(intentL1)
        }

        ButUM.setOnClickListener {
//запуск урока умножение
            val intentL2 = Intent(this, Les2Activity::class.java)
            startActivity(intentL2)
        }

        ButDel.setOnClickListener {
//запуск старницы деления
            val intentL3 = Intent(this, Les3Activity::class.java)
            startActivity(intentL3)
        }

        ButDr.setOnClickListener {
//запуск старницы дробей
            val intentL4 = Intent(this, Les4Activity::class.java)
            startActivity(intentL4)
        }

        ButDdro.setOnClickListener {
//запуск старницы десятичных дробей дробей
            val intentL5 = Intent(this, Les5Activity::class.java)
            startActivity(intentL5)
        }

        ButOtr.setOnClickListener {
//запуск старницы отрицательных чисел
            val intentL6 = Intent(this, Les6Activity::class.java)
            startActivity(intentL6)
        }

        ButUr.setOnClickListener {
//запуск старницы уравнений
            val intentL7 = Intent(this, Les7Activity::class.java)
            startActivity(intentL7)
        }

        ButIt.setOnClickListener {
//запуск итогового теста
            val UserLevel = sharedPreferences.getInt("Level", 0)
            if (UserLevel >= 7) {
                val intentItog = Intent(this, ItogActivity::class.java)
                startActivity(intentItog)
            }
            else {Toast.makeText(this, "сначала пройти остальные уроки!",Toast.LENGTH_LONG).show()
            // sound
            val mediaPlayer = MediaPlayer.create(this, R.raw.fl)
            mediaPlayer.start()}
        }


        delet.setOnClickListener {
//запуск cтраницы удаления
            val intentdel = Intent(this, DelActivity::class.java)
            startActivity(intentdel)
        }

        ButST.setOnClickListener {
//запуск cтраницы статистики
            val intentS = Intent(this, StatActivity::class.java)
            startActivity(intentS)
        }


//отображение имени и уровня
        val UserName = sharedPreferences.getString("name", "User1")
        textV7.text = UserName

        val UserLevel = sharedPreferences.getInt("Level", 0)
        when {
            UserLevel in 1..4 -> LevelV.text = "Уровень: $UserLevel, Так держать!"
            UserLevel in 5..6 -> LevelV.text = "Уровень: $UserLevel, Ты почти у цели"
            UserLevel in 7..8 -> {
                LevelV.text = "Уровень: $UserLevel, Ты почти у цели"
                }
            UserLevel in 9..10 -> {
                LevelV.text = "Уровень: $UserLevel (Максимальный)"
                }
            else -> LevelV.text = "Уровень: $UserLevel"

        }

//делаем текст подчеркнутым
        sslk.paint.isUnderlineText = true

//создаем переход на сайт при нажатии на текст с ггаэком
        sslk.setOnClickListener {
            val intentSSil = Intent(Intent.ACTION_VIEW, Uri.parse("https://ggaek.by/"))
            startActivity(intentSSil)
        }



    }
}