package likelion.project.fit_a_pet.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import likelion.project.fit_a_pet.AuthApplication
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.base.BaseActivity
import likelion.project.fit_a_pet.databinding.ActMainBinding
import likelion.project.fit_a_pet.ui.view.auth.LoginActivity

class MainActivity : BaseActivity<ActMainBinding>(R.layout.act_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
    }

    // token 정보 확인 -> 없으면 LoginActivity로
    override fun onStart() {
        super.onStart()
    }

    // onResum에서 token 정보 갱신
    override fun onResume() {
        super.onResume()

        val access = AuthApplication.prefs.getAccessToken("access", "no access token")
        val refresh = AuthApplication.prefs.getRefreshToken("refresh", "no refresh token")
        Log.e("TOKEN_PREF", access)
        Log.e("TOKEN_PREF", refresh)
    }

    fun onBtnClick(v : View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
