package likelion.project.fit_a_pet.view

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.base.BaseActivity
import likelion.project.fit_a_pet.databinding.ActMainBinding
import likelion.project.fit_a_pet.view.auth.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActMainBinding

//    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActMainBinding.inflate(layoutInflater) // xml에 있는 View 객체화
        setContentView(binding.root)

        supportActionBar?.hide()
    }

    override fun onStart() {
        super.onStart()
    }

    fun onBtnClick(v : View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
