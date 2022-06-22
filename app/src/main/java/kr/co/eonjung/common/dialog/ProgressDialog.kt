package kr.co.eonjung.common.dialog

import android.app.Activity
import kr.co.eonjung.databinding.DialogProgressBinding

class ProgressDialog (activity: Activity, cancelable: Boolean = true) : BaseDialog(activity, cancelable) {

    lateinit var binding : DialogProgressBinding

    override fun initValues() {
        super.initValues()
        binding = DialogProgressBinding.inflate(layoutInflater)
    }

    override fun initWidgets() {
        super.initWidgets()
        setContentView(binding.root)
    }

    fun setMsg(msg: String) {
        binding.txtLoading.text = msg
        if (!isShowing) {
            show()
        }
    }
}