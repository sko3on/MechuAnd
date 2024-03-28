package com.example.mechuand.userui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityUserRegistBinding

// 유저 회원가입 화면
class UserRegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_regist)

        var binding = ActivityUserRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnUJoin = findViewById<Button>(R.id.btnUJoin)
        var btnExit = findViewById<Button>(R.id.btnExit)

        binding.btnUJoin.setOnClickListener {
            var intent = Intent(applicationContext, MechuHomeActivity::class.java)
            startActivity(intent)
        }
        binding.btnExit.setOnClickListener { finish() }
    }
}