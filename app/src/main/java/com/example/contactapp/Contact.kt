package com.example.contactapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    var nome:String,
    var phone:String,
    var photo:String
): Parcelable{
}
