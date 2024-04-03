package com.example.mechuand.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReMenuOrderDTO(
    var oNum: Long? = null,
    var orderMenu: String? = null,
    var menuCount: Int = 0,

    var rNum: Long? = null,
    var uNum: Long? = null
) : Parcelable