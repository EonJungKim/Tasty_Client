package kr.co.eonjung.common.vo

import com.google.gson.annotations.SerializedName

data class IntValVO(

    @SerializedName("status") val status: StatusVO,
    @SerializedName("result") val result: Int
)