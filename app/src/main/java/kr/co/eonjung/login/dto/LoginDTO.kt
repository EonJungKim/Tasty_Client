package kr.co.eonjung.login.dto

import com.google.gson.annotations.SerializedName

data class LoginDTO(
    @SerializedName("id")   var id: String,
    @SerializedName("pwd")  var pwd: String
)
