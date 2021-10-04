package com.example.exam3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name:String, val lastname:String, val email:String, ):Parcelable
//data class User(val name:String, val lastname:String, val email:String,val specialOne:SpecialUser?=null ){
//    data class SpecialUser(val name:String, val lastname:String, val email:String)
//}