package com.example.mechuand.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreMenuDTO(
    var mNum: Long? = null,
    var mName: String? = null,
    var mPrice: String? = null,
    var description: String? = null,


    var sNum: Long? = null
) : Parcelable