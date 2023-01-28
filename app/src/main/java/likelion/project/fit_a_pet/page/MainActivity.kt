package likelion.project.fit_a_pet.page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.base.BaseActivity
import likelion.project.fit_a_pet.databinding.ActMainBinding
import likelion.project.fit_a_pet.page.view.auth.LoginActivity

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
    }

    fun onBtnClick(v : View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
