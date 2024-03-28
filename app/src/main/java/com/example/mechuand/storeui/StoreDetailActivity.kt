package com.example.mechuand.storeui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityStoreDetailBinding


// 처음 사업자 회원가입하면 해야하는 필수 정보 입력창
// 카테고리/휴무일/광고
class StoreDetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)

        var binding = ActivityStoreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnDetailEnd = findViewById<Button>(R.id.btnDetailEnd)

        binding.btnDetailEnd.setOnClickListener {
            var intent = Intent(applicationContext, MenudesActivity::class.java)
            startActivity(intent)
        }
    }
}