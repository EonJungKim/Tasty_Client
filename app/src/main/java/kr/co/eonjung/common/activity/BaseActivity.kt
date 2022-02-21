package kr.co.eonjung.common.activity

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kr.co.eonjung.common.net.RetrofitClient
import kr.co.eonjung.common.net.RetrofitService
import kr.co.eonjung.common.util.SharedPrefUtil

open class BaseActivity : AppCompatActivity(), View.OnClickListener  {

    protected lateinit var TAG: String
    lateinit var sharedPrefUtil: SharedPrefUtil
    lateinit var retrofitService: RetrofitService
    protected lateinit var finishIntent: Intent

    protected open fun init() {
        try {
            initUtils()
            initValues()
            initWidgets()
            setFinishIntent()
        } catch (e: Exception) {
            print(e);
        }
    }

    protected open fun initUtils() {
        sharedPrefUtil = SharedPrefUtil(this)
        retrofitService = RetrofitClient.getInstance().create(RetrofitService::class.java)
    }

    protected open fun initValues() { }

    protected open fun initWidgets() { }

    protected open fun setFinishIntent() {
        val requestCode = intent.getIntExtra("requestCode", -1)
        if (requestCode != -1) {
            finishIntent = Intent()
            finishIntent.putExtra("requestCode", requestCode)
            setResult(RESULT_OK, finishIntent)
        }
    }

    override fun onClick(view: View?) { }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun print(msg: String) {
        Log.e(TAG, msg)
    }

    fun getText(textView: TextView): String {
        return textView.text.toString().trim()
    }
}