package kr.co.eonjung.common.util

import android.app.Activity
import android.view.View
import kr.co.eonjung.common.dialog.AlertDialog
import kr.co.eonjung.common.dialog.ProgressDialog

class DialogUtil(activity: Activity) {

    val progressDlg: ProgressDialog = ProgressDialog(activity)
    val alertDlg: AlertDialog = AlertDialog(activity)

    fun showProgress(msg: String = "Loading...") {
        if (alertDlg.isShowing) {
            hideAlert()
        }
        progressDlg.setMsg(msg)
    }

    fun hideProgress() {
        if (progressDlg.isShowing) {
            progressDlg.hide()
        }
    }

    fun showAlert(title: String, content: String,
                  strPos: String, evtPos: View.OnClickListener = alertDlg.evtNull,
                  strNut: String = "", evtNut: View.OnClickListener = alertDlg.evtNull,
                  strNgt: String = "", evtNgt: View.OnClickListener = alertDlg.evtNull) {
        if (progressDlg.isShowing) {
            hideProgress()
        }

        alertDlg.setView(title, content, strPos, evtPos, strNut, evtNut, strNgt, evtNgt)
    }

    fun hideAlert() {
        if (alertDlg.isShowing) {
            alertDlg.hide()
        }
    }

    fun destroy() {
        hideProgress()
        hideAlert()
    }
}