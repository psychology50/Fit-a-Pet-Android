package likelion.project.fit_a_pet.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {
    // MODE_PRIVATE : 생성한 Application에서만 사용 가능
    private val accessPrefs: SharedPreferences =
        context.getSharedPreferences("access", Context.MODE_PRIVATE)
    private val refreshPrefs: SharedPreferences =
        context.getSharedPreferences("refresh", Context.MODE_PRIVATE)

    fun getAccessToken(key: String, defValue: String): String {
        return accessPrefs.getString(key, defValue).toString()
    }

    fun setAccessToken(key: String, str: String) {
        accessPrefs.edit().putString(key, str).apply()
    }

    fun getRefreshToken(key: String, defValue: String): String {
        return refreshPrefs.getString(key, defValue).toString()
    }

    fun setRefreshToken(key: String, str: String) {
        refreshPrefs.edit().putString(key, str).apply()
    }
}