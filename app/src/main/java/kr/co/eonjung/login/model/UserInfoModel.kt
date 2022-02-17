package kr.co.eonjung.login.model

import com.google.gson.annotations.SerializedName

data class UserInfoModel(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String
)
