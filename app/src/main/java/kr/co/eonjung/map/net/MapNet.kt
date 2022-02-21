package kr.co.eonjung.map.net

import android.widget.Toast
import kr.co.eonjung.map.activity.MapActivity
import kr.co.eonjung.map.vo.POIInfoVO
import kr.co.eonjung.map.vo.POIListVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapNet(val activity: MapActivity) {

    fun getPOIList(category: String?, lat: Double, lon: Double) {
        activity.retrofitService.getPOIList(category!!, lat, lon).enqueue(object: Callback<POIListVO> {
            override fun onResponse(call: Call<POIListVO>, response: Response<POIListVO>) {
                val status = response.body()?.status!!
                val userInfo = response.body()?.poiList!!

                when(status.resultCd) {
                    "OK" -> {

                    }
                    else -> {
                        Toast.makeText(activity, status.resultMsg, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<POIListVO>, t: Throwable) {
                Toast.makeText(activity, "서버와의 통신에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                activity.print(t.toString())
            }
        })
    }

    fun getPOIInfo(gid: Int) {
        activity.retrofitService.getPOIInfo(gid).enqueue(object: Callback<POIInfoVO> {
            override fun onResponse(call: Call<POIInfoVO>, response: Response<POIInfoVO>) {
                val status = response.body()?.status!!
                val poiInfo = response.body()?.poiInfo!!

                when(status.resultCd) {
                    "OK" -> {

                    }
                    else -> {
                        Toast.makeText(activity, status.resultMsg, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<POIInfoVO>, t: Throwable) {
                Toast.makeText(activity, "서버와의 통신에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                activity.print(t.toString())
            }
        })
    }
}