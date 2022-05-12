package kr.co.eonjung.login.activity

import android.view.View
import kr.co.eonjung.R
import kr.co.eonjung.common.activity.BaseActivity
import kr.co.eonjung.databinding.ActivityLoginBinding
import kr.co.eonjung.login.dialog.FindIdPwdDialog
import kr.co.eonjung.login.net.LoginNet

class LoginActivity : BaseActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var net: LoginNet

    lateinit var findIdPwdDlg: FindIdPwdDialog

    companion object {
        lateinit var userId: String
    }

    override fun initValues() {
        TAG = localClassName

        binding = ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun initUtils() {
        super.initUtils()
        net = LoginNet(this)

        findIdPwdDlg = FindIdPwdDialog(this)
    }

    override fun initWidgets() {
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
        binding.btnFindIdPwd.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnLogin -> net.getLogin(getText(binding.edtId), getText(binding.edtPwd))
            R.id.btnFindIdPwd -> FindIdPwdDialog(this).show()
        }
    }
}