package com.example.mechuand.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreDetailDTO(
    var dNum: Long? = null,
    var premium: String? = null, // 광고
    var category: String? = null, // 카테고리

    var offDay: String? = null, // 휴무일

//    @ManyToOne
//    @JoinColumn(name = "snum")
//    var storeDTO: StoreDTO? = null,
//    @Transient
//    var sNum: Long? = null
) : Parcelable