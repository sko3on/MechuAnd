package com.example.mechuand.storeui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityStoreDetailBinding


// 처음 사업자 회원가입하면 해야하는 필수 정보 입력창
// 카테고리/휴무일/광고
class StoreDetailActivity : AppCompatActivity() {
    private lateinit var sId: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)

        var binding = ActivityStoreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 사용자 아이디 TextView 초기화
        sId = findViewById(R.id.sId)

        // Intent에서 사용자 아이디를 가져와서 표시
        val sId = intent.getStringExtra("sId")
        sId.text = "사용자 아이디: $sId"

        var btnDetailEnd = findViewById<Button>(R.id.btnDetailEnd)

        binding.btnDetailEnd.setOnClickListener {
            var intent = Intent(applicationContext, MenudesActivity::class.java)
            startActivity(intent)
        }
    }
}