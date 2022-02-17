package kr.co.eonjung.common.vo

import com.google.gson.annotations.SerializedName

data class StatusVO(
    @SerializedName("resultCd")     val resultCd: String,
    @SerializedName("resultMsg")    val resultMsg: String
)
