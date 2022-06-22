package kr.co.eonjung.map.net

import android.widget.Toast
import kr.co.eonjung.common.net.BaseNet
import kr.co.eonjung.map.activity.MapActivity
import kr.co.eonjung.map.vo.RstntInfoVO
import kr.co.eonjung.map.vo.RstntListVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapNet(val activity: MapActivity) : BaseNet(activity) {

    fun getRstntList(category: String?, lat: Double, lon: Double) {
        activity.retrofitService.getRstntList(category!!, lat, lon).enqueue(object: Callback<RstntListVO> {
            override fun onResponse(call: Call<RstntListVO>, response: Response<RstntListVO>) {
                val status = response.body()?.status!!
                val rstntList = response.body()?.rstntList!!

                when(status.resultCd) {
                    "OK" -> {

                    }
                    else -> {
                        Toast.makeText(activity, status.resultMsg, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<RstntListVO>, t: Throwable) {
                netFail(t)
            }
        })
    }

    fun getRstnt(gid: Int) {
        activity.retrofitService.getRstnt(gid).enqueue(object: Callback<RstntInfoVO> {
            override fun onResponse(call: Call<RstntInfoVO>, response: Response<RstntInfoVO>) {
                val status = response.body()?.status!!
                val rstntInfo = response.body()?.rstntInfo!!

                when(status.resultCd) {
                    "OK" -> {

                    }
                    else -> {
                        Toast.makeText(activity, status.resultMsg, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<RstntInfoVO>, t: Throwable) {
                netFail(t)
            }
        })
    }
}