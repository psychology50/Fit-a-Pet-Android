package likelion.project.fit_a_pet.view.auth

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.base.BaseActivity
import likelion.project.fit_a_pet.databinding.ActLoginBinding

class LoginActivity : BaseActivity<ActLoginBinding>(R.layout.act_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.onBackPressedDispatcher.addCallback(this, backBtn)

    }

    private val backBtn = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            Log.e("Back", "뒤로가기 클릭")
            finish()
        }
    }
}