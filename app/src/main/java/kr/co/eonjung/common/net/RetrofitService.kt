package kr.co.eonjung.common.net

import kr.co.eonjung.common.define.DefineUrl
import kr.co.eonjung.login.vo.LoginVO
import kr.co.eonjung.map.vo.POIInfoVO
import kr.co.eonjung.map.vo.POIListVO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {

    // Associated with user
    @GET(DefineUrl.URL_USER_LOGIN)
    fun getLogin(@Query("id") id: String, @Query("pwd") pwd: String) : Call<LoginVO>

    @POST(DefineUrl.URL_USER_LOGIN)
    fun postLogin(@Query("id") id: String, @Query("pwd") pwd: String) : Call<LoginVO>

    // Associated with map
    @GET(DefineUrl.URL_MAP_POI_LIST)
    fun getPOIList(@Query("category") category: String,
                   @Query("lat") lat: Double,
                   @Query("lon") lon: Double) : Call<POIListVO>

    @GET(DefineUrl.URL_MAP_POI_INFO)
    fun getPOIInfo(@Query("gid") gid: Int) : Call<POIInfoVO>
}