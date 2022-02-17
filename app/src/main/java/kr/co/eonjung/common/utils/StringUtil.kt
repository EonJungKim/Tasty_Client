package kr.co.eonjung.common.utils

import java.text.SimpleDateFormat
import java.util.*

object StringUtil {

    fun chkNullStr(str: String) = (str == "") || (str.lowercase() == "null")

    fun getCurDate(type: Int): String {
        val dateFormat = when (type) {
            1 -> SimpleDateFormat("yyyy", Locale("ko", "KR"))
            2 -> SimpleDateFormat("yyyy-MM", Locale("ko", "KR"))
            3 -> SimpleDateFormat("yyyy-MM-dd", Locale("ko", "KR"))
            else -> SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale("ko", "KR"))
        }

        return dateFormat.format(Date(System.currentTimeMillis()))
    }
}