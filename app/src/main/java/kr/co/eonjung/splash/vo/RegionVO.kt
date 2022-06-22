package kr.co.eonjung.splash.vo

import com.google.gson.annotations.SerializedName
import kr.co.eonjung.common.db.entity.Region
import kr.co.eonjung.common.vo.StatusVO

data class RegionVO (

    @SerializedName("status") val status: StatusVO,
    @SerializedName("regions") val regions: List<Region>
)