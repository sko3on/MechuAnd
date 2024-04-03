package com.example.mechuand.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReservationDTO(
    var rNum: Long? = null,
    var person: Int? = 0,
    var hour: Int? = 0,
    var minute: Int? = 0,
    var orderTime: Long? = null,

    var sNum: Long? = null,
    var uNum: Long? = null
) : Parcelable