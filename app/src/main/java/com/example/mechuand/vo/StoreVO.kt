package com.example.mechuand.vo
import android.os.Parcel
import android.os.Parcelable

class StoreVO (
    var sNum: Long,
    var sId: String?,
    var sPw: String?,
    var sName: String?,
    var sMobile: String?,
    var businessNum: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(sNum)
        parcel.writeString(sId)
        parcel.writeString(sPw)
        parcel.writeString(sName)
        parcel.writeString(sMobile)
        parcel.writeString(businessNum)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StoreVO> {
        override fun createFromParcel(parcel: Parcel): StoreVO {
            return StoreVO(parcel)
        }

        override fun newArray(size: Int): Array<StoreVO?> {
            return arrayOfNulls(size)
        }
    }
    }
