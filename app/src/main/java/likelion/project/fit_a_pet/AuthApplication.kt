package likelion.project.fit_a_pet

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import likelion.project.fit_a_pet.utils.PreferenceUtil

@HiltAndroidApp
class AuthApplication: Application() {
    companion object {
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate() {
        super.onCreate()
        prefs = PreferenceUtil(applicationContext)
    }
}