package com.fashi.githubtrend.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Repository(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("watchers_count")
    val stars: Int,
    @SerializedName("full_name")
    var authorName:String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0!!.writeString(id)
        p0!!.writeString(name)
        p0!!.writeInt(stars)
        p0.writeString(authorName)

    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<Repository> {
        override fun createFromParcel(parcel: Parcel): Repository {
            return Repository(parcel)
        }

        override fun newArray(size: Int): Array<Repository?> {
            return arrayOfNulls(size)
        }
    }
}
