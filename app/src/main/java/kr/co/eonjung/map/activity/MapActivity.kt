package kr.co.eonjung.map.activity

import android.os.Bundle
import kr.co.eonjung.common.activity.BaseActivity
import kr.co.eonjung.databinding.ActivityMapBinding
import kr.co.eonjung.map.net.MapNet
import kr.co.eonjung.map.util.MapLocUtil
import net.daum.mf.map.api.MapView

class MapActivity : BaseActivity() {

    lateinit var binding: ActivityMapBinding
    lateinit var net: MapNet
    lateinit var locUtil: MapLocUtil
    lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    override fun initValues() {
        TAG = localClassName
        mapView = MapView(this)
    }

    override fun initUtils() {
        super.initUtils()
        net = MapNet(this)
        locUtil = MapLocUtil(this)
    }

    override fun initWidgets() {
       binding.mapViewContainer.addView(mapView)
    }

    override fun onResume() {
        super.onResume()
        locUtil.startUpdate()
    }

    override fun onPause() {
        super.onPause()
        locUtil.stopUpdate()
    }
}