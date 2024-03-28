package com.example.mechuand.userui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityMechuHomeBinding

// 유저 로그인 시 넘어오는 화면
class MechuHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechu_home)

        var binding = ActivityMechuHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 메뉴추천
        var imageButton = findViewById<ImageButton>(R.id.imageButton)
        // 메뉴배틀
        var imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        // 주문내역
        var imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        // 예약확인
        var imageButton4 = findViewById<ImageButton>(R.id.imageButton4)

        binding.imageButton.setOnClickListener {
            var intent = Intent(applicationContext, PickActivity::class.java)
            startActivity(intent)
        }
        binding.imageButton2.setOnClickListener {
            var intent = Intent(applicationContext, BattleActivity::class.java)
            startActivity(intent)
        }
        binding.imageButton3.setOnClickListener {
            var intent = Intent(applicationContext, OrderActivity::class.java)
            startActivity(intent)
        }
        binding.imageButton4.setOnClickListener {
            var intent = Intent(applicationContext, ReservationActivity::class.java)
            startActivity(intent)
        }
    }
}