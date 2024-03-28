package com.example.mechuand.userui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityOrderBinding

// MechuHome > btn : 주문내역
class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}