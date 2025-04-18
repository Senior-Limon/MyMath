package com.example.mymathwithggaek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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



        //        нужно для работы с инфой и последующего обращения по ключу
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)


//        for rename user
        val Edition = sharedPreferences.getString("EditName","error")
        if (Edition == "1") {
            button.text = "переименовать"
        }

        //        создание интента для перехода на другую старницу
        val intent = Intent(this, GLActivity::class.java)





//    для работы с данными    val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
//    вызов данных по ключу   val value = sharedPreferences.getString("name", "Ошибка") name - ключ

        val value = sharedPreferences.getString("name", "")
        if (value != "")
            startActivity(intent)

        button.setOnClickListener {
            val text = userData.text.toString().trim()
            if(text != ""){
                // Сохранение данных
                Toast.makeText(this, "Добро пожаловать $text", Toast.LENGTH_SHORT).show()
                val editorName = sharedPreferences.edit()
                editorName.putString("name", text)
                editorName.apply()

                startActivity(intent)
            }

            else {

                Toast.makeText(this, "Вы ничего не ввели!!!", Toast.LENGTH_SHORT).show()
            }




        }

    }
}