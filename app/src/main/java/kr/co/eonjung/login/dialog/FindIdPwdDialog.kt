package kr.co.eonjung.login.dialog

import android.view.View
import kr.co.eonjung.R
import kr.co.eonjung.common.dialog.BaseDialog
import kr.co.eonjung.databinding.DialogFindIdPwdBinding
import kr.co.eonjung.login.activity.LoginActivity

class FindIdPwdDialog (private val activity: LoginActivity, cancelable: Boolean = true) : BaseDialog(activity, cancelable) {

    lateinit var binding : DialogFindIdPwdBinding

    override fun initValues() {
        super.initValues()
        binding = DialogFindIdPwdBinding.inflate(layoutInflater)
    }

    override fun initWidgets() {
        super.initWidgets()
        setContentView(binding.root)

        binding.swFindDlgType.setOnClickListener(this)
        binding.btnFindDlgFind.setOnClickListener(this)
        binding.btnFindDlgLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.swFindDlgType -> {
                if (!binding.swFindDlgType.isChecked) {
                    binding.layoutFindDlgId.visibility = View.GONE
                } else {
                    binding.layoutFindDlgId.visibility = View.VISIBLE
                    binding.edtFindDlgId.text.clear()
                }
            }
            R.id.btnFindDlgFind -> {
                if (!binding.swFindDlgType.isChecked) {
                    activity.net.getId(activity.getText(binding.edtFindDlgNm))
                } else {
                    activity.net.getPwd(activity.getText(binding.edtFindDlgNm), activity.getText(binding.edtFindDlgId))
                }
            }
            R.id.btnFindDlgLogin -> dismiss()
        }
    }

    fun showResult(result: String, isSuccess: Boolean = false) {
        binding.btnFindDlgLogin.visibility = if (isSuccess) {
            View.VISIBLE
        } else {
            View.GONE
        }

        binding.txtFindDlgResult.visibility = View.VISIBLE
        binding.txtFindDlgResult.text = result
    }
}