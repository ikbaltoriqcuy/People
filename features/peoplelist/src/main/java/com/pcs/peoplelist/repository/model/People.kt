package com.pcs.peoplelist.repository.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
Created by ikbaltoriq on 28,August,2024
 **/

data class People(
    val createdAt: String,
    val name: String,
    val avatar: String,
    val city: String,
    val country: String,
    val county: String,
    val addressNo: String,
    val street: String,
    @SerializedName("zip_code")
    val zipCode: String,
    val id: String
)