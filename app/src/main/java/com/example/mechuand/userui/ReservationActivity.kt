package com.example.mechuand.userui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityReservationBinding

// MechuHome > btn : 주문확인
class ReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        var binding = ActivityReservationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}