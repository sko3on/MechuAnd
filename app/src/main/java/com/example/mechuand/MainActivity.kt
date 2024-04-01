package com.example.mechuand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mechuand.databinding.ActivityMainBinding
import com.example.mechuand.sqltest.TestActivity
import com.example.mechuand.storeui.StoreActivity
import com.example.mechuand.userui.MechuHomeActivity
import com.example.mechuand.userui.UserRegistActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 회원가입 버튼
        val btnReg = findViewById<Button>(R.id.btnReg)
        // 로그인 버튼
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        // 유저 > 사업자 변환
        val btnCh = findViewById<Button>(R.id.btnSCh)

        // 버튼클릭시 실행동작
        
        // 회원가입 이동
        binding.btnReg.setOnClickListener {
            var intent = Intent(applicationContext, UserRegistActivity::class.java)
            startActivity(intent)
        }
        
        // 로그인 아이디 비밀번호 유사성 검사 후 true => HomeActivity 이동 false => 다시
        binding.btnLogin.setOnClickListener {
            var intent = Intent(applicationContext, MechuHomeActivity::class.java)
            startActivity(intent)
        }
        
        // 유저 로그인창 > 사업자 로그인 창으로 이동
        binding.btnSCh.setOnClickListener {
            var intent = Intent(applicationContext, StoreActivity::class.java)
            startActivity(intent)
        }

        // TestPage
        val btnTestP =  findViewById<Button>(R.id.btnTestP)
        binding.btnTestP.setOnClickListener {
            var intent = Intent(applicationContext, TestActivity::class.java)
            startActivity(intent)
        }
    }
}