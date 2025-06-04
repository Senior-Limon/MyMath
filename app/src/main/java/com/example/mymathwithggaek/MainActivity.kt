package com.example.mymathwithggaek

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userData:EditText = findViewById(R.id.editText)
        val button:Button = findViewById(R.id.button)
        val sslk: TextView = findViewById(R.id.textViewss)
        val mediaPlayer = MediaPlayer.create(this, R.raw.oprivet)


        //        нужно для работы с инфой и последующего обращения по ключу
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)


//        for rename user
        val Edition = sharedPreferences.getString("EditName","error")
        if (Edition == "1") {
            button.text = "переименовать"
        }

//        обработка нажатия на кнопку войти\переименовать
        button.setOnClickListener {
            val text = userData.text.toString().trim()
            if(text != ""){
                // Сохранение данных
                Toast.makeText(this, "Добро пожаловать $text", Toast.LENGTH_SHORT).show()
                val editorName = sharedPreferences.edit()
                editorName.putString("name", text)
                editorName.apply()

                val intent = Intent(this, GLActivity::class.java)
                mediaPlayer.start()
                startActivity(intent)
                }

            else {

                Toast.makeText(this, "Вы ничего не ввели!!!", Toast.LENGTH_SHORT).show()
                }

        }
        //создаем переход на сайт при нажатии на текст с ггаэком
        sslk.setOnClickListener {
            val intentSSil = Intent(Intent.ACTION_VIEW, Uri.parse("https://ggaek.by/"))
            startActivity(intentSSil)
            }
    }
}