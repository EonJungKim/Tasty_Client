package kr.co.eonjung.splash.activity

import android.Manifest
import android.content.Intent
import android.os.Build
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kr.co.eonjung.R
import kr.co.eonjung.common.activity.BaseActivity
import kr.co.eonjung.login.activity.LoginActivity
import kr.co.eonjung.splash.net.InitNet

class SplashActivity : BaseActivity() {

    lateinit var net: InitNet

    override fun init() {
        super.init()
        checkPermissions()
    }

    override fun initValues() {
        TAG = localClassName
    }

    override fun initUtils() {
        super.initUtils()
        net = InitNet(this)
    }

    override fun initWidgets() {
        setContentView(R.layout.activity_splash)
    }

    private fun checkPermissions() {
        if (Build.VERSION.SDK_INT >= 23) { // 마시멜로(안드로이드 6.0) 이상 권한 체크
            TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setRationaleMessage("앱을 이용하기 위해서는 접근 권한이 필요합니다")
                .setDeniedMessage("앱에서 요구하는 권한설정이 필요합니다...\n [설정] > [권한] 에서 사용으로 활성화해주세요.")
                .setPermissions(
                    Manifest.permission.INTERNET,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ).check()
        }
    }

    private var permissionlistener: PermissionListener = object : PermissionListener {
        override fun onPermissionGranted() { // 권한 허가시 실행 할 내용
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }

        override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
            // 권한 거부시 실행  할 내용
            Toast.makeText(this@SplashActivity, "권한 허용을 하지 않으면 서비스를 이용할 수 없습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRegion() {
        val regionDao = getDb().regionDao()
        if (regionDao.getCount() == 0) {

        }
    }
}