package com.example.mechuand.storeui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityUpdateMenuBinding

// Menudes 에서 메뉴 클릭시 넘어오는 화면
// 메뉴의 상세정보 + 수정 + 삭제 가능한 페이지
class UpdateMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_menu)

        var binding = ActivityUpdateMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}