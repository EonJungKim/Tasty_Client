package kr.co.eonjung.common.define

import java.net.URL

object DefineUrl {
    // Base Setting
    const val URL_BASE = "http://220.124.4.195:28088"
//    const val URL_BASE = "http://192.168.0.22:8080/"

    // Associated with initialize
    const val URL_INIT_REGION    = "$URL_BASE/init/region.do"

    // Associated with user
    const val URL_USER_LOGIN     = "$URL_BASE/user/login.do"
    const val URL_LOGIN_FIND_ID  = "$URL_BASE/user/findId.do"
    const val URL_LOGIN_FIND_PWD = "$URL_BASE/user/findPwd.do"

    // Associated with map
    const val URL_MAP_RSTNT_LIST = "$URL_BASE/map/rstntList.do"
    const val URL_MAP_RSTNT      = "$URL_BASE/map/rstnt.do"
}