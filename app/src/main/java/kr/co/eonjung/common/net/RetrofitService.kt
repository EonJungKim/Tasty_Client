package kr.co.eonjung.common.net

import kr.co.eonjung.common.define.DefineUrl
import kr.co.eonjung.login.vo.LoginVO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {

    @GET(DefineUrl.URL_USER_LOGIN)
    fun getLogin(@Query("id") id: String, @Query("pwd") pwd: String) : Call<LoginVO>

    @POST(DefineUrl.URL_USER_LOGIN)
    fun postLogin(@Query("id") id: String, @Query("pwd") pwd: String) : Call<LoginVO>
}