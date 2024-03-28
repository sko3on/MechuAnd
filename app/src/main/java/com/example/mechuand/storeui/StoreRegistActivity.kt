package com.example.mechuand.storeui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityStoreRegistBinding

// 사업자 회원가입 화면
// btnJoin > StoreDetail로 이동
class StoreRegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_regist)

        var binding = ActivityStoreRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // StoreDetail
        var btnSJoin = findViewById<Button>(R.id.btnSJoin)
        var btnExit = findViewById<Button>(R.id.btnExit)

        binding.btnSJoin.setOnClickListener {
            var intent = Intent(applicationContext, StoreDetailActivity::class.java)
            startActivity(intent)
        }
        binding.btnExit.setOnClickListener { finish() }

    }
}