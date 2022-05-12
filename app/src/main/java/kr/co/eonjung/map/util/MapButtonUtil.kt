package kr.co.eonjung.map.util

import android.view.View
import android.widget.Toast
import kr.co.eonjung.R
import kr.co.eonjung.map.activity.MapActivity

class MapButtonUtil(private val activity: MapActivity) {

    fun btnInit() {
        activity.binding.apply {
            btnMenu.setOnClickListener(activity)
            btnSch.setOnClickListener(activity)
            btnSTT.setOnClickListener(activity)
            btnGPS.setOnClickListener(activity)
            btnAddRstnt.setOnClickListener(activity)
            btnSelLoc.setOnClickListener(activity)
            btnAddCancel.setOnClickListener(activity)
        }
    }

    fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnMenu -> {
                Toast.makeText(activity, "Menu button is clicked.", Toast.LENGTH_SHORT).show()
            }
            R.id.btnSch -> {
                Toast.makeText(activity, "Search button is clicked.", Toast.LENGTH_SHORT).show()
            }
            R.id.btnSTT -> {
                Toast.makeText(activity, "Speech to text button is clicked.", Toast.LENGTH_SHORT).show()
            }
            R.id.btnGPS -> {
                activity.run {
                    mapView.setMapCenterPoint(locUtil.curLoc, true)
                }
            }
            R.id.btnAddRstnt -> {
                activity.binding.apply {
                    ivCenter.visibility = View.VISIBLE
                    btnSelLoc.visibility = View.VISIBLE
                    btnAddCancel.visibility = View.VISIBLE
                }
            }
            R.id.btnSelLoc -> {
                Toast.makeText(activity, "Add restaurant button is clicked.", Toast.LENGTH_SHORT).show()
            }
            R.id.btnAddCancel -> {
                Toast.makeText(activity, "Add restaurant button is clicked.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun chgVisibility() {

    }
}