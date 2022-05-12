package kr.co.eonjung.common.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View

open class BaseDialog(activity: Activity, private val cancelable: Boolean) : Dialog(activity), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initUtils()
        initValues()
        initWidgets()
    }

    protected open fun initUtils() {

    }

    protected open fun initValues() {

    }

    protected open fun initWidgets() {
        setCancelable(cancelable)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onClick(view: View?) {  }
}