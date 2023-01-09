package likelion.project.fit_a_pet.view.splash

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import likelion.project.fit_a_pet.view.MainActivity
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.base.BaseActivity
import likelion.project.fit_a_pet.databinding.ActSplashBinding
import kotlin.concurrent.thread

class SplashActivity : BaseActivity<ActSplashBinding>(R.layout.act_splash) {
    var isReady = false
    var isStart = false

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        initSplashScreen()
    }

    private fun initSplashScreen() {
        initData()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            errorGuard()

            val content: View = findViewById(android.R.id.content)
            content.viewTreeObserver.addOnPreDrawListener(
                object: ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        return if (isReady) {
                            content.viewTreeObserver.removeOnPreDrawListener(this)
                            true
                        } else {
                            false
                        }
                    }

                }
            )

//            splashScreen.setOnExitAnimationListener { splashScreenView ->
//                val slideUp = ObjectAnimator.ofFloat(
//                    splashScreenView,
//                    View.TRANSLATION_Y,
//                    0f,
//                    -splashScreenView.height.toFloat()
//                )
//                slideUp.interpolator = AnticipateInterpolator()
//                slideUp.duration = 1000L
//                isStart = true
//
//                slideUp.doOnEnd {
//                    splashScreenView.remove()
//                    startMainActivity()
//                }
//
//                slideUp.start()
//            }
        } else {
            startMainActivity()
        }
    }

    private fun initData() {
        thread(start = true) {
            for (i in 1..3) {
                Thread.sleep(1000)
                Log.d("SplashAct", "Sleep .. i = $i")
            }
            isReady = true
        }
    }

    private fun errorGuard() {
        thread(start = true) {
            Thread.sleep(1000)

            if (!isStart) {
                Log.d("SplashAct" , "start $isStart :: startActivity")
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
        thread(start = true) {
            Thread.sleep(1000)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}