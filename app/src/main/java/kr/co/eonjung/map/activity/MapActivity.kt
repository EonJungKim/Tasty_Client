package kr.co.eonjung.map.activity

import android.os.Handler
import android.os.Looper
import android.view.View
import kr.co.eonjung.common.activity.BaseActivity
import kr.co.eonjung.databinding.ActivityMapBinding
import kr.co.eonjung.map.net.MapNet
import kr.co.eonjung.map.util.MapButtonUtil
import kr.co.eonjung.map.util.MapLocUtil
import kr.co.eonjung.map.util.MapViewUtil
import net.daum.mf.map.api.MapView

class MapActivity : BaseActivity() {

    companion object {
        const val STATE_CDE_NER = 0
        const val STATE_CDE_SCH = 1
        const val STATE_CDE_ADD = 2
        const val STATE_CDE_UDT = 3
        var state = STATE_CDE_SCH
    }

    lateinit var binding: ActivityMapBinding
    lateinit var mapView: MapView

    lateinit var net: MapNet
    lateinit var mapViewUtil: MapViewUtil
    lateinit var btnUtil: MapButtonUtil
    lateinit var locUtil: MapLocUtil

    override fun init() {
        super.init()
        Handler(Looper.getMainLooper()).postDelayed({
            mapViewUtil.initMap()
        }, 2000)
    }

    override fun initValues() {
        TAG = localClassName
        binding = ActivityMapBinding.inflate(layoutInflater)
    }

    override fun initUtils() {
        super.initUtils()
        net = MapNet(this)

        mapViewUtil = MapViewUtil(this)
        btnUtil = MapButtonUtil(this)
        locUtil = MapLocUtil(this)
    }

    override fun initWidgets() {
        setContentView(binding.root)

        binding.mapViewContainer.addView(mapView)
        btnUtil.btnInit()
    }

    override fun onResume() {
        super.onResume()
        locUtil.startUpdate()
        mapViewUtil.initMap()
    }

    override fun onPause() {
        super.onPause()
        locUtil.stopUpdate()
    }

    override fun onClick(view: View?) {
        btnUtil.onClick(view)
    }

    fun chgState() {
        when (state) {
            STATE_CDE_NER -> {

            }
            STATE_CDE_SCH -> {

            }
            STATE_CDE_ADD -> {

            }
            STATE_CDE_UDT -> {

            }
        }
    }
}