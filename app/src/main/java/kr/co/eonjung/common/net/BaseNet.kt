package kr.co.eonjung.common.net

import android.widget.Toast
import kr.co.eonjung.common.activity.BaseActivity

open class BaseNet(private val activity: BaseActivity) {

    protected fun netFail(t: Throwable) {
        Toast.makeText(activity, "서버와의 통신에 실패하였습니다.", Toast.LENGTH_SHORT).show()
        activity.print(t.toString())
    }
}