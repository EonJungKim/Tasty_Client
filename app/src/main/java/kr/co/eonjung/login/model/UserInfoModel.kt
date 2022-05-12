package kr.co.eonjung.login.model

import com.google.gson.annotations.SerializedName

data class UserInfoModel(
    @SerializedName("idx") var id: Int,
    @SerializedName("userId") var userId: String,
    @SerializedName("userPwd") var userPwd: String,
    @SerializedName("userNm") var userNm: String,
    @SerializedName("regDate") var regDate: String
)
