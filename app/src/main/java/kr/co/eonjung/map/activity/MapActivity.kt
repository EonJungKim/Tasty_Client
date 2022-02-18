package kr.co.eonjung.map.activity

import android.location.LocationManager
import android.os.Bundle
import kr.co.eonjung.common.activity.BaseActivity
import kr.co.eonjung.databinding.ActivityMapBinding
import kr.co.eonjung.map.net.MapNet
import kr.co.eonjung.map.util.MapLocUtil
import net.daum.mf.map.api.MapCurrentLocationMarker
import net.daum.mf.map.api.MapPoint

class MapActivity : BaseActivity() {

    lateinit var binding: ActivityMapBinding
    lateinit var net: MapNet
    lateinit var locUtil: MapLocUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    override fun init() {
        super.init()
        locUtil.startUpdate()
    }

    override fun initValues() {
        TAG = localClassName
    }

    override fun initUtils() {
        super.initUtils()
        net = MapNet(this)
        locUtil = MapLocUtil(this)
    }

    override fun initWidgets() {
        binding.mapView.apply{
//            this.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(35.815653, 127.103519), true)
            this.setZoomLevel(7, true)
            this.setCurrentLocationMarker(MapCurrentLocationMarker())
        }
    }
}