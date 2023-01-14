package likelion.project.fit_a_pet.page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import likelion.project.fit_a_pet.databinding.ActMainBinding
import likelion.project.fit_a_pet.page.view.auth.LoginActivity

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
