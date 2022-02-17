package kr.co.eonjung.login.net

import android.widget.Toast
import kr.co.eonjung.login.activity.LoginActivity
import kr.co.eonjung.login.vo.LoginVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginNet(val activity: LoginActivity) {

    fun getLogin(id: String, pwd: String) {
        activity.retrofitService.postLogin(id, pwd).enqueue(object: Callback<LoginVO> {
            override fun onResponse(call: Call<LoginVO>, response: Response<LoginVO>) {
                val status = response.body()?.status!!
                val userInfo = response.body()?.userInfo!!

                when(status.resultCd) {
                    "OK" -> {
                        activity.sharedPrefUtil.setUserInfo(userInfo)
                    }
                    else -> {
                        Toast.makeText(activity, status.resultMsg, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<LoginVO>, t: Throwable) {
                Toast.makeText(activity, "서버와의 통신에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                activity.print(t.toString())
            }
        })
    }
}