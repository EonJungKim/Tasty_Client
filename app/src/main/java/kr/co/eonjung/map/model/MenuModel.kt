package kr.co.eonjung.map.model

import com.google.gson.annotations.SerializedName

data class MenuModel (
    @SerializedName("name") var name: String,
    @SerializedName("price") var price: Int,
    @SerializedName("point") var point: Double,
    @SerializedName("content") var content: String,
    @SerializedName("fileIdList") var fileIdList: List<Int>
)