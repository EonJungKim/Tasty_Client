package kr.co.eonjung.map.vo

import com.google.gson.annotations.SerializedName
import kr.co.eonjung.common.vo.StatusVO
import kr.co.eonjung.map.model.POIInfoModel

data class POIInfoVO (
    @SerializedName("status") val status: StatusVO,
    @SerializedName("poiInfo") val poiInfo: POIInfoModel
)