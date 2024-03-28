package com.example.mechuand.userui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityBattleBinding

// MechuHome > btn:메뉴 배틀
class BattleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle)

        var binding = ActivityBattleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}