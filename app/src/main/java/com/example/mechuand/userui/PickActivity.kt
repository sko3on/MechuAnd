package com.example.mechuand.userui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityPickBinding

// MechuHome > btn : 메뉴 추천
class PickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick)

        var binding = ActivityPickBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}