package kr.co.eonjung.map.util

import android.annotation.SuppressLint
import android.content.Context.LOCATION_SERVICE
import android.graphics.Color
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import kr.co.eonjung.map.activity.MapActivity
import net.daum.mf.map.api.MapCircle
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

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

class MapLocUtil(var activity: MapActivity) {

    companion object {
        const val MIN_UDT_TIME = 10000L     // 최소 갱신 시간
        const val MIN_UDT_DST   = 10.0f     // 최소 갱신 거리

        const val CENT_CIRC_TAG = 0;
        const val CENT_CIRC_DIST = 1000
        val CENT_CIRC_STRK = Color.argb(128, 255, 0, 0)
        val CENT_CIRC_FILL = Color.argb(30, 255, 255, 0)

        var isTracking = true
        lateinit var centerCircle: MapCircle
        lateinit var centerPoiItem: MapPOIItem
    }

    private var locManager: LocationManager = activity.getSystemService(LOCATION_SERVICE) as LocationManager
    private var locListener: LocationListener

    lateinit var curLoc: MapPoint

    init {
        locListener = LocationListener { location ->
            curLoc = MapPoint.mapPointWithGeoCoord(location.latitude, location.longitude)

            centerCircle = MapCircle(curLoc, CENT_CIRC_DIST, CENT_CIRC_STRK, CENT_CIRC_FILL)
            centerCircle.tag = CENT_CIRC_TAG

            centerPoiItem = MapPOIItem()
            centerPoiItem.apply {
                this.mapPoint = curLoc
            }

            if (isTracking) {
                activity.mapView.setMapCenterPoint(curLoc, true)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    var circle = activity.mapView.findCircleByTag(CENT_CIRC_TAG)

                    if (circle == null) {
                        circle = centerCircle
                        activity.mapView.addCircle(circle)
                    }

                    circle.center = curLoc
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun startUpdate() {
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER      , MIN_UDT_TIME, MIN_UDT_DST, locListener)
        locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER  , MIN_UDT_TIME, MIN_UDT_DST, locListener)

        MapView.setMapTilePersistentCacheEnabled(true)
        activity.mapView.apply {
            this.mapType = MapView.MapType.Hybrid

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                this.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeadingWithoutMapMoving
                this.setShowCurrentLocationMarker(true)
                this.setCurrentLocationRadius(CENT_CIRC_DIST)
                this.setCurrentLocationRadiusStrokeColor(CENT_CIRC_STRK)
                this.setCurrentLocationRadiusFillColor(CENT_CIRC_FILL)
            }
        }
    }

    fun stopUpdate() {
        locManager.removeUpdates(locListener)
    }
}
