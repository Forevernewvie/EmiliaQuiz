package com.example.firstapp.fragment

import android.util.Log

class contentData(

    val num : Int,
    val question : String,
    val img  : Int,
    val O_Img : Int,
    val X_Imag : Int,
    val check : Boolean
){

    val TAG:String="로그"

    init {
        Log.d(TAG, "contentData - init called ")
    }
}
