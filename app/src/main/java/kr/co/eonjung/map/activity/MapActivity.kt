package kr.co.eonjung.map.activity

import android.os.Bundle
import kr.co.eonjung.common.activity.BaseActivity
import kr.co.eonjung.databinding.ActivityMapBinding
import kr.co.eonjung.login.activity.LoginActivity
import kr.co.eonjung.map.net.MapNet

class MapActivity : BaseActivity() {

    companion object {
        lateinit var binding: ActivityMapBinding
        lateinit var net: MapNet
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(LoginActivity.binding.root)

        init()
    }

    override fun initValues() {
        TAG = localClassName
    }

    override fun initUtils() {
        super.initUtils()
        net = MapNet(this)
    }
}