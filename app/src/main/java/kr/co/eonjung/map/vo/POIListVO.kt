package kr.co.eonjung.map.vo

import com.google.gson.annotations.SerializedName
import kr.co.eonjung.common.vo.StatusVO
import kr.co.eonjung.map.model.POIModel

data class POIListVO (

    @SerializedName("status") val status: StatusVO,
    @SerializedName("poiList") val poiList: List<POIModel>
)