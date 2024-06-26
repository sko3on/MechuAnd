package com.example.mechuand.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreDTO(
    var sNum: Long? = null,
    var sId: String? = null,
    var sPw: String? = null,
    var sName: String? = null,
    var sMobile: String? = null,
    var businessNum: String? = null,
) : Parcelable
