package com.example.mechuand.vo

import android.os.Parcel
import android.os.Parcelable

class StoreDetailVO(
    var dNum: Long? = null,
    var premium: String? = null, // 광고
    var category: String? = null, // 카테고리
    var offDay: String? = null, // 휴무일
    var sNum: Long? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(dNum)
        parcel.writeString(premium)
        parcel.writeString(category)
        parcel.writeString(offDay)
        parcel.writeValue(sNum)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StoreDetailVO> {
        override fun createFromParcel(parcel: Parcel): StoreDetailVO {
            return StoreDetailVO(parcel)
        }

        override fun newArray(size: Int): Array<StoreDetailVO?> {
            return arrayOfNulls(size)
        }
    }
}
