package kr.co.eonjung.common.dialog

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.annotation.Nullable
import kr.co.eonjung.databinding.DialogAlertBinding
import kr.co.eonjung.databinding.DialogProgressBinding

class AlertDialog (activity: Activity, cancelable: Boolean = true) : BaseDialog(activity, cancelable) {

    lateinit var binding : DialogAlertBinding

    override fun initValues() {
        super.initValues()
        binding = DialogAlertBinding.inflate(layoutInflater)
    }

    override fun initWidgets() {
        super.initWidgets()
        setContentView(binding.root)
    }

    fun setView(
        title: String, content: String,
        strPos: String, evtPos: View.OnClickListener = evtNull,
        strNut: String = "", evtNeu: View.OnClickListener = evtNull,
        strNgt: String = "", evtNgt: View.OnClickListener = evtNull
    ) {
        binding.apply {
            txtTitle.text = title
            txtContent.text = content
            btnPositive.text = strPos
            btnPositive.setOnClickListener(evtPos)

            if (strNut == "") {
                btnNeutral.visibility = View.GONE
            } else {
                btnNeutral.text = strNut
                btnNeutral.setOnClickListener(evtNeu)
            }

            if (strNgt == "") {
                btnNegative.visibility = View.GONE
            } else {
                btnNegative.text = strNgt
                btnNegative.setOnClickListener(evtNgt)
            }
        }

        if (!isShowing) {
            show()
        }
    }

    val evtNull = View.OnClickListener { dismiss() }
}