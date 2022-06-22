package kr.co.eonjung.common.net

import kr.co.eonjung.common.db.entity.Region
import kr.co.eonjung.common.define.DefineUrl
import kr.co.eonjung.common.vo.BoolValVO
import kr.co.eonjung.common.vo.IntValVO
import kr.co.eonjung.common.vo.StrValVO
import kr.co.eonjung.login.vo.LoginVO
import kr.co.eonjung.map.vo.RstntInfoVO
import kr.co.eonjung.map.vo.RstntListVO
import kr.co.eonjung.splash.vo.RegionVO
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    // Initialize
    @GET(DefineUrl.URL_INIT_REGION)
    fun getResion() : Call<RegionVO>

    // Login
    // 사용자 로그인
    @GET(DefineUrl.URL_USER_LOGIN)
    fun getLogin(@Query("userId") userId: String, @Query("userPwd") userPwd: String) : Call<LoginVO>

    // ID 조회
    @GET(DefineUrl.URL_LOGIN_FIND_ID)
    fun getId(@Query("name") name: String) : Call<StrValVO>

    // PWD 조회
    @GET(DefineUrl.URL_LOGIN_FIND_PWD)
    fun getPwd(@Query("name") name: String, @Query("id") id: String) : Call<StrValVO>

//    @POST(DefineUrl.URL_USER_LOGIN)
//    fun postLogin(@Query("id") id: String, @Query("pwd") pwd: String) : Call<LoginVO>

    // Associated with map
    @GET(DefineUrl.URL_MAP_RSTNT_LIST)
    fun getRstntList(@Query("category") category: String,
                   @Query("lat") lat: Double,
                   @Query("lon") lon: Double) : Call<RstntListVO>

    @GET(DefineUrl.URL_MAP_RSTNT)
    fun getRstnt(@Query("gid") gid: Int) : Call<RstntInfoVO>

    @POST(DefineUrl.URL_MAP_RSTNT)
    fun postRstnt() : Call<IntValVO>

    @PUT(DefineUrl.URL_MAP_RSTNT)
    fun udtRstnt() : Call<BoolValVO>

    @DELETE(DefineUrl.URL_MAP_RSTNT)
    fun delRstnt() : Call<BoolValVO>
}