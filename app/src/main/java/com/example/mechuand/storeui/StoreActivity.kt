package com.example.mechuand.storeui

import android.content.Intent
import com.example.mechuand.MainActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityStoreBinding

// 사업자 로그인화면
class StoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        var binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // StoreRegist << 사업자 회원가입
        var btnReg = findViewById<Button>(R.id.btnReg)
        // UpdateMenu << 메뉴 추가
        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var btnUCh = findViewById<Button>(R.id.btnUCh)

        binding.btnReg.setOnClickListener {
            var intent = Intent(applicationContext, StoreRegistActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            var intent = Intent(applicationContext, MenudesActivity::class.java)
            startActivity(intent)
        }
        binding.btnUCh.setOnClickListener{
            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}