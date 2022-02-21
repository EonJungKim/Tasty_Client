package kr.co.eonjung.map.activity

import android.os.Bundle
import android.view.View
import kr.co.eonjung.R
import kr.co.eonjung.common.activity.BaseActivity
import kr.co.eonjung.databinding.ActivityMapBinding
import kr.co.eonjung.map.net.MapNet
import kr.co.eonjung.map.util.MapLocUtil
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
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
        binding.btnTest.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        locUtil.startUpdate()

        val poiItem = MapPOIItem()
        poiItem.mapPoint = MapPoint.mapPointWithGeoCoord(35.794136, 127.128357)
        poiItem.tag = -1
        poiItem.markerType = MapPOIItem.MarkerType.BluePin
        mapView.addPOIItem(poiItem)
    }

    override fun onPause() {
        super.onPause()
        locUtil.stopUpdate()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnTest -> {
                val poiItem = mapView.findPOIItemByTag(-1)

                if (poiItem == null) {
                    val poiItem = MapPOIItem()
                    poiItem.mapPoint = MapPoint.mapPointWithGeoCoord(35.794136, 127.128357)
                    poiItem.tag = -1
                    poiItem.itemName = "Test POI"
                    poiItem.markerType = MapPOIItem.MarkerType.BluePin
                    mapView.addPOIItem(poiItem)
                } else {
                    poiItem.mapPoint = MapPoint.mapPointWithGeoCoord(35.793777, 127.130154)
                }
            }
        }
    }
}