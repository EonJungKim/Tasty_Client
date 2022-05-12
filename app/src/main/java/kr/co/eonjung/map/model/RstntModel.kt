package kr.co.eonjung.map.model

import com.google.gson.annotations.SerializedName

class RstntModel (
    @SerializedName("gid") var gid: Int,
    @SerializedName("lat") var lat: Double,
    @SerializedName("lon") var lon: Double,
    @SerializedName("name") var name: String,
    @SerializedName("category") var category: String
)