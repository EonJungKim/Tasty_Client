package kr.co.eonjung.map.vo

import com.google.gson.annotations.SerializedName
import kr.co.eonjung.common.vo.StatusVO
import kr.co.eonjung.map.model.RstntModel

data class RstntListVO (

    @SerializedName("status") val status: StatusVO,
    @SerializedName("rstntList") val rstntList: List<RstntModel>
)