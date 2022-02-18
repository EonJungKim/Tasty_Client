package kr.co.eonjung.map.util

import android.annotation.SuppressLint
import android.content.Context.LOCATION_SERVICE
import android.graphics.Color
import android.location.LocationListener
import android.location.LocationManager
import kr.co.eonjung.map.activity.MapActivity
import net.daum.mf.map.api.MapCircle
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint


/**
 * @파일제목   : MapLocUtil
 * @패키지명   : kr.co.eonjung.map.util
 * @소유      : 명지정보기술
 * @생성자    : 김언중
 * @생성날짜   : 2022-02-18
 *
 * == 수정사항 ==
 * ------------------------------------
 * 2022-02-18  김언중 최초 생성
 */

@SuppressLint("MissingPermission")
class MapLocUtil(var activity: MapActivity) {

    companion object {
        const val TAG_CIRC_CUR = 0          // 현 위치에 대한 반경 TAG

        const val MIN_UDT_TIME = 10000L     // 최소 갱신 시간
        const val MIN_UDT_DST   = 10.0f     // 최소 갱신 거리

        var isTracking = true
    }

    private var locManager: LocationManager
    var locListener: LocationListener

    lateinit var curLoc: MapPoint
    lateinit var centerCircle: MapCircle

    init {
        locListener = LocationListener { location ->
            curLoc = MapPoint.mapPointWithGeoCoord(location.latitude, location.longitude)

            if (isTracking) {
                centerCircle = MapCircle(curLoc, 1000, Color.argb(128, 255, 0, 0), Color.argb(200, 255, 255, 0))
                centerCircle.tag = TAG_CIRC_CUR

                activity.mapView.apply {
                    this.setMapCenterPoint(curLoc, true)
                    if (this.findCircleByTag(TAG_CIRC_CUR) == null) {
                        this.addCircle(centerCircle)
                    }
                }
            }
        }

        locManager = activity.getSystemService(LOCATION_SERVICE) as LocationManager
    }

    fun startUpdate() {
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER      , MIN_UDT_TIME, MIN_UDT_DST, locListener)
        locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER  , MIN_UDT_TIME, MIN_UDT_DST, locListener)
    }

    fun stopUpdate() {
       locManager.removeUpdates(locListener)
    }

    fun addPoiList(poiList: List<MapPOIItem>) {
        for (poi in poiList) {

        }
    }
}