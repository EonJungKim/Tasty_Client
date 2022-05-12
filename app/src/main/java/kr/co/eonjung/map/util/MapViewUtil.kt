package kr.co.eonjung.map.util

import kr.co.eonjung.map.activity.MapActivity
import kr.co.eonjung.map.model.RstntModel
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class MapViewUtil(private val activity: MapActivity) {

    val poiTagList = emptyList<Int>()

    init {
        activity.mapView = MapView(activity)
    }

    fun initMap() {
        activity.mapView.apply {
            MapView.setMapTilePersistentCacheEnabled(true)
            currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeadingWithoutMapMoving
            setShowCurrentLocationMarker(true)
            setCurrentLocationRadius(MapLocUtil.CENT_CIRC_DIST)
            setCurrentLocationRadiusStrokeColor(MapLocUtil.CENT_CIRC_STRK)
            setCurrentLocationRadiusFillColor(MapLocUtil.CENT_CIRC_FILL)
        }
    }

    private fun convRstntToPOI(rstntInfo: RstntModel): MapPOIItem {
        return MapPOIItem().apply {
            mapPoint = MapPoint.mapPointWithGeoCoord(rstntInfo.lat, rstntInfo.lon)
            itemName = rstntInfo.name
            tag = rstntInfo.gid
            markerType = MapPOIItem.MarkerType.BluePin
            showAnimationType = MapPOIItem.ShowAnimationType.SpringFromGround
        }
    }

    fun addMarker(rstntInfo: RstntModel) {
        activity.mapView.addPOIItem(convRstntToPOI(rstntInfo))
    }

    fun addMarkers(rstntList: List<RstntModel>) {
        val poiItems = ArrayList<MapPOIItem>()

        for (rstntInfo in rstntList) {
            addMarker(rstntInfo)
        }

        activity.mapView.addPOIItems(poiItems.toTypedArray())
    }

    fun delMarker(tag: Int) {
        activity.mapView.apply {
            removePOIItem(findPOIItemByTag(tag))
        }
    }

    fun delMakers(tagList: List<Int>) {
        val poiItems = emptyArray<MapPOIItem>()

        activity.mapView.apply {
            for (tag in tagList) {
                poiItems.plus(findPOIItemByTag(tag))
            }
            removePOIItems(poiItems)
        }
    }

    fun chgMarkerVisible(tag: Int, visible: Boolean) {
        if (visible) {
            activity.mapView.findPOIItemByTag(tag).alpha = 1.0f
        } else {
            activity.mapView.findPOIItemByTag(tag).alpha = 0.0f
        }
    }

    fun chgMarkersVisible(tagList: List<Int>, visible: Boolean) {
        for (tag in tagList) {
            chgMarkerVisible(tag, visible)
        }
    }

    fun chgAllMarkersVisible(visible: Boolean) {
        chgMarkersVisible(poiTagList, visible)
    }
}