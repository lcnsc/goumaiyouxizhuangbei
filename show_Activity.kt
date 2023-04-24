package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView.FindListener
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import java.net.CacheRequest

class show_Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_layout)
        val name = intent.getStringExtra("name")
        val password = intent.getStringExtra("password")
        val tv_name: TextView = findViewById(R.id.tv_name)
        val tv_password: TextView = findViewById(R.id.tv_ps)
        tv_name.text = name
        tv_password.text = password
        val pb_life: ProgressBar = findViewById(R.id.pb_life)
        val pb_gj: ProgressBar = findViewById(R.id.pb_gj)
        val pb_fy: ProgressBar = findViewById(R.id.pb_fy)
        pb_life.max = 100
        pb_gj.max = 100
        pb_fy.max = 100
        val but_buy: Button = findViewById(R.id.but_buy)
        but_buy.setOnClickListener {
            val intent = Intent(this, shop_Activity::class.java)
            startActivityForResult(intent, 1)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == 1) {
                val equitment = data?.getSerializableExtra("equipment") as equipment
                update(equitment)
            }
        }
    }

    fun update(equipment: equipment) {
        val pb_life: ProgressBar = findViewById(R.id.pb_life)
        val pb_gj: ProgressBar = findViewById(R.id.pb_gj)
        val pb_fy: ProgressBar = findViewById(R.id.pb_fy)
        pb_life.progress = pb_life.progress + equipment.life
        pb_gj.progress = pb_life.progress + equipment.gj
        pb_fy.progress = pb_life.progress + equipment.fy
        val tv_life :TextView = findViewById(R.id.tv_life)
        val tv_gj :TextView = findViewById(R.id.tv_gj)
        val tv_fy :TextView = findViewById(R.id.tv_fy)
        tv_life.text =  pb_life.progress.toString()
        tv_gj.text =  pb_gj.progress.toString()
        tv_fy.text =  pb_fy.progress.toString()
    }
}
