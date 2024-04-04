package com.example.mechuand.storeui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityStoreRegistBinding

// 사업자 회원가입 화면
// btnJoin > StoreDetail로 이동
class StoreRegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStoreRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 저장 버튼 클릭 시
        binding.btnSJoin.setOnClickListener {
            // 입력된 값 가져오기
            val storeName = binding.editStoreName.text.toString().trim()
            val storeId = binding.editStoreId.text.toString().trim()
            val storePw = binding.editStorePw.text.toString().trim()
            val storePhone = binding.edtiStorePhone.text.toString().trim()
            val storeNum = binding.editStoreNum.text.toString().trim()

            // 입력값이 비어있는지 확인
            if (storeName.isEmpty() || storeId.isEmpty() || storePw.isEmpty() || storePhone.isEmpty() || storeNum.isEmpty()) {
                Toast.makeText(this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 저장 처리

            // 로그인 화면으로 이동
            val intent = Intent(this, StoreActivity::class.java)
            startActivity(intent)
        }

        // 취소 버튼 클릭 시 현재 화면 종료
        binding.btnExit.setOnClickListener {
            finish()
        }
    }
}
