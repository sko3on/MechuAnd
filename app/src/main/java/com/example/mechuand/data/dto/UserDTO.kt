package com.example.mechuand.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDTO(
    var uNum: Long? = null,
    var uId: String? = null,
    var uPw: String? = null,
    var uEmail: String? = null,
    var uName: String? = null,
    var uBirth: Long? = null,
    var uGender: String? = null,
    var uMobile: String? = null,


) : Parcelable
