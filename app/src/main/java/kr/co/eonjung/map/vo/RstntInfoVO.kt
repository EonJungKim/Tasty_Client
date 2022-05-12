package kr.co.eonjung.map.vo

import com.google.gson.annotations.SerializedName
import kr.co.eonjung.common.vo.StatusVO
import kr.co.eonjung.map.model.RstntModel

data class RstntInfoVO (
    @SerializedName("status") val status: StatusVO,
    @SerializedName("rstntInfo") val rstntInfo: RstntModel
)