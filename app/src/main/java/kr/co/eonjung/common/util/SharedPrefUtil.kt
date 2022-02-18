package kr.co.eonjung.common.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit
import kr.co.eonjung.R
import kr.co.eonjung.login.model.UserInfoModel

class SharedPrefUtil(private val context: Context) {

    companion object {
        const val DEF_STR = ""
        const val DEF_INT = 0
        const val DEF_LNG = 0L
        const val DEF_FLT = 0F
        const val DEF_BOL = false
    }

    private fun getPref(): SharedPreferences {
        return context.getSharedPreferences(
            context.getString(R.string.str_shared_pref),
            MODE_PRIVATE
        )
    }

    fun getBoolProp(id: String): Boolean {
        return getPref().getBoolean(id, DEF_BOL)
    }

    fun getIntProp(id: String): Int {
        return getPref().getInt(id, DEF_INT)
    }

    fun getLongProp(id: String): Long {
        return getPref().getLong(id, DEF_LNG)
    }

    fun getFltProp(id: String): Float {
        return getPref().getFloat(id, DEF_FLT)
    }

    fun getStrProp(id: String): String? {
        return getPref().getString(id, DEF_STR)
    }

    fun setUserInfo(userInfo: UserInfoModel) {
        val pref: SharedPreferences = getPref()
        pref.edit {
            putString("user_id", userInfo.id)
            putString("user_name", userInfo.name)
            commit()
        }
    }

    fun getUserInfo(): UserInfoModel {
        val pref: SharedPreferences = getPref()

        return UserInfoModel(pref.getString("user_id", DEF_STR)!!, pref.getString("user_name", DEF_STR)!!)
    }
}
