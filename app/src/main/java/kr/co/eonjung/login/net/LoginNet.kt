package kr.co.eonjung.login.net

import android.content.Intent
import android.widget.Toast
import kr.co.eonjung.common.net.BaseNet
import kr.co.eonjung.common.vo.StrValVO
import kr.co.eonjung.login.activity.LoginActivity
import kr.co.eonjung.login.vo.LoginVO
import kr.co.eonjung.map.activity.MapActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginNet(val activity: LoginActivity) : BaseNet(activity) {

    fun getLogin(userId: String, userPwd: String) {
        activity.retrofitService.getLogin(userId, userPwd).enqueue(object: Callback<LoginVO> {
            override fun onResponse(call: Call<LoginVO>, response: Response<LoginVO>) {
                val status = response.body()?.status!!

                when(status.resultCd) {
                    "OK" -> {
                        activity.sharedPrefUtil.setUserInfo(response.body()?.userInfo!!)

                        if (activity.binding.ckSavId.isChecked) {
                            activity.sharedPrefUtil.savLoginId(userId)
                        }

                        Toast.makeText(activity, "${userId}님 환영합니다.", Toast.LENGTH_SHORT).show()

                        activity.startActivity(Intent(activity, MapActivity::class.java))
                        activity.finish()
                    }
                    else -> Toast.makeText(activity, status.resultMsg, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginVO>, t: Throwable) {
                netFail(t)
            }
        })
    }

    fun getId(name: String) {
        activity.retrofitService.getId(name).enqueue(object: Callback<StrValVO> {
            override fun onResponse(call: Call<StrValVO>, response: Response<StrValVO>) {
                val status = response.body()?.status!!

                when(status.resultCd) {
                    "OK" -> activity.findIdPwdDlg.showResult(response.body()?.result!!, true)
                    else -> Toast.makeText(activity, status.resultMsg, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<StrValVO>, t: Throwable) {
                netFail(t)
            }
        })
    }

    fun getPwd(name: String, id: String) {
        activity.retrofitService.getPwd(name, id).enqueue(object: Callback<StrValVO> {
            override fun onResponse(call: Call<StrValVO>, response: Response<StrValVO>) {
                val status = response.body()?.status!!

                when(status.resultCd) {
                    "OK" -> activity.findIdPwdDlg.showResult(response.body()?.result!!, true)
                    else -> Toast.makeText(activity, status.resultMsg, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<StrValVO>, t: Throwable) {
                netFail(t)
            }
        })
    }
}