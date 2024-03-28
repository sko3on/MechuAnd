package com.example.mechuand.storeui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityMenudesBinding


// 메뉴 정보/추가 << detail or 로그인 후 넘어오는 화면
class MenudesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menudes)

        var binding = ActivityMenudesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnAddMenu = findViewById<Button>(R.id.btnAddMenu)
        var btnMenuDetail = findViewById<Button>(R.id.btnMenuDetail)

        binding.btnAddMenu.setOnClickListener {
            var intent = Intent(applicationContext, UpdateMenuActivity::class.java)
            startActivity(intent)
        }
        binding.btnMenuDetail.setOnClickListener {
            var intent = Intent(applicationContext, UpdateMenuActivity::class.java)
            startActivity(intent)
        }
    }
}