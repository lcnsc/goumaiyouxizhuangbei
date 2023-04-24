package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.myapplication.equipment
class shop_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_)
        val equipment = equipment("金剑",10,20,30)
        val tv_spname : TextView = findViewById(R.id.tv_spname)
        val tv_shop_life : TextView = findViewById(R.id.tv_shop_life)
        val tv_shop_gj : TextView = findViewById(R.id.tv_shop_gj)
        val tv_shop_fy : TextView = findViewById(R.id.tv_shop_fy)
        tv_spname.text = "${equipment.name}"
        tv_shop_life.text = "生命力：${equipment.life}"
        tv_shop_gj.text = "攻击力：${equipment.gj}"
        tv_shop_fy.text = "防御力：${equipment.fy}"
        val r1 :RelativeLayout = findViewById(R.id.r1)
        r1.setOnClickListener {
            val intent = Intent()
            intent.putExtra("equipment",equipment)
            setResult(1,intent)
            finish()
        }

    }
}