package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but_log : Button = findViewById(R.id.but_login)
        val et_user : EditText = findViewById(R.id.et_user)
        val et_ps : EditText = findViewById(R.id.et_ps)

        but_log.setOnClickListener {
            val name = et_user.text.toString()
            val password = et_ps.text.toString()
            val intent = Intent(this,show_Activity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("password",password)
            startActivity(intent)
        }


    }
}