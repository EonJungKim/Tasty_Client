package kr.co.eonjung.map.util

import android.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.eonjung.map.activity.MapActivity
import kr.co.eonjung.map.model.RegionModel

class MapSpinnerUtil(private val activity: MapActivity) {

    val strSiDoList = emptyList<RegionModel>()
    val strSggList = emptyList<RegionModel>()
    val strUmdList = emptyList<RegionModel>()

    fun spinnerInit() {
        strSiDoList.plus(RegionModel("__", "전체"))
        strSggList.plus(RegionModel("__", "전체"))
        strUmdList.plus(RegionModel("__", "전체"))

        activity.binding.apply {
            spStat.adapter = ArrayAdapter(activity, R.layout.simple_spinner_dropdown_item, activity.resources.getStringArray(kr.co.eonjung.R.array.arr_map_sp_stat))
            spStat.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) { }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    activity.chgState(position)
                }
            }

//            spSido.adapter = ArrayAdapter(activity, R.layout.simple_spinner_dropdown_item, ac)
        }
    }
}