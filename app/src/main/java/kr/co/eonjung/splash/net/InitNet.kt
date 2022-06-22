package kr.co.eonjung.splash.net

import android.content.Intent
import android.widget.Toast
import kr.co.eonjung.common.net.BaseNet
import kr.co.eonjung.login.activity.LoginActivity
import kr.co.eonjung.splash.activity.SplashActivity
import kr.co.eonjung.splash.vo.RegionVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InitNet(val activity: SplashActivity) : BaseNet(activity) {

    fun getRstntList() {
        activity.retrofitService.getResion().enqueue(object: Callback<RegionVO> {
            override fun onResponse(call: Call<RegionVO>, response: Response<RegionVO>) {
                val status = response.body()?.status!!
                val regions = response.body()?.regions!!

                when(status.resultCd) {
                    "OK" -> {
                        activity.getDb().regionDao().insRegion(regions)
                        activity.startActivity(Intent(activity, LoginActivity::class.java))
                        activity.finish()
                    }
                    else -> {
                        Toast.makeText(activity, status.resultMsg, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<RegionVO>, t: Throwable) {
                netFail(t)
            }
        })
    }
}