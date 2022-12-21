package likelion.project.fit_a_pet.utils

import android.app.Activity
import android.widget.Toast
import likelion.project.fit_a_pet.R

class BackPressUtil(private val activity: Activity) {
    private var backKeyPressTime = 0L
    private var toast: Toast? = null

    fun onBackPressed() {
        if (System.currentTimeMillis() <= backKeyPressTime + 2000) {
            toast!!.cancel()
            activity.finish()
        } else {
            backKeyPressTime = System.currentTimeMillis()

        }
    }

    private fun showToast() {
        toast = Toast.makeText(activity, activity.getString(R.string.app_name), Toast.LENGTH_SHORT)
        toast!!.show()
    }
}