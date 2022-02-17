package kr.co.eonjung.login.vo

import com.google.gson.annotations.SerializedName
import kr.co.eonjung.common.vo.StatusVO
import kr.co.eonjung.login.model.UserInfoModel

data class LoginVO (
    @SerializedName("status") val status: StatusVO,
    @SerializedName("userInfo") val userInfo: UserInfoModel
)