package kr.co.eonjung.login.activity

import android.os.Bundle
import android.view.View
import kr.co.eonjung.R
import kr.co.eonjung.common.activity.BaseActivity
import kr.co.eonjung.databinding.ActivityLoginBinding
import kr.co.eonjung.login.net.LoginNet

class LoginActivity : BaseActivity() {

    companion object {
        lateinit var binding: ActivityLoginBinding
        lateinit var net: LoginNet
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    override fun initValues() {
        TAG = localClassName
    }

    override fun initUtils() {
        super.initUtils()
        net = LoginNet(this)
    }

    override fun initWidgets() {
        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnLogin -> {
                net.getLogin(getText(binding.edtId), getText(binding.edtPwd))
            }
        }
    }
}