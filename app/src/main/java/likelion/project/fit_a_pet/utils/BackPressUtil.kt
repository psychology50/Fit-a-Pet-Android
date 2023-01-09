package likelion.project.fit_a_pet.utils

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import likelion.project.fit_a_pet.R

class BackPressUtil(private val activity: Activity) {
    private var backKeyPressTime = 0L
    private var toast: Toast? = null

    fun onBackPressed() {
        if (System.currentTimeMillis() <= backKeyPressTime + 2000) {
            toast?.cancel()
            activity.finish()
//            this.onBackPressedDispatcher.addCallback(this, backBtn)
        } else {
            backKeyPressTime = System.currentTimeMillis()
        }
    }

    private val backBtn = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            Log.e("Back", "뒤로가기 클릭")
            activity.finish()
        }
    }

    private fun showToast() {
        toast = Toast.makeText(activity, activity.getString(R.string.app_name), Toast.LENGTH_SHORT)
        toast!!.show()
    }
}