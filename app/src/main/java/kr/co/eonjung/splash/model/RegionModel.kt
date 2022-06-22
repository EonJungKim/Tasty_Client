package kr.co.eonjung.splash.model

import com.google.gson.annotations.SerializedName

data class RegionModel(
    @SerializedName("idx") var id: Int,
    @SerializedName("code") var code: String,
    @SerializedName("name") var name: String
)
