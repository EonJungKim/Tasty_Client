package kr.co.eonjung.map.activity

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.eonjung.R
import kr.co.eonjung.common.activity.BaseActivity
import kr.co.eonjung.databinding.ActivityMapBinding
import kr.co.eonjung.map.net.MapNet
import kr.co.eonjung.map.util.MapButtonUtil
import kr.co.eonjung.map.util.MapLocUtil
import kr.co.eonjung.map.util.MapViewUtil
import net.daum.mf.map.api.MapView

class MapActivity : BaseActivity() {

    companion object {
        const val STAT_CDE_NER = 0  // 주변
        const val STAT_CDE_SCH = 1  // 조회
        const val STAT_CDE_ADD = 2  // 등록
        const val STAT_CDE_UDT = 3  // 갱신
    }

    var state = STAT_CDE_SCH

    lateinit var binding: ActivityMapBinding
    lateinit var mapView: MapView

    lateinit var net: MapNet
    lateinit var mapViewUtil: MapViewUtil
    lateinit var btnUtil: MapButtonUtil
    lateinit var locUtil: MapLocUtil

    override fun init() {
        super.init()
        Handler(Looper.getMainLooper()).postDelayed({ mapViewUtil.initMap() }, 2000)
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

    fun chgState(state: Int) {
        this.state = state
        btnUtil.chgBtnVisibility()
        when (this.state) {
            STAT_CDE_NER -> {
                mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
            }
            STAT_CDE_SCH -> {
                mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeadingWithoutMapMoving
            }
            STAT_CDE_ADD -> {

            }
            STAT_CDE_UDT -> {

            }
        }
    }
}