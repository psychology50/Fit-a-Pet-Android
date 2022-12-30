package likelion.project.fit_a_pet.view

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.databinding.ActMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActMainBinding

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActMainBinding.inflate(layoutInflater) // xml에 있는 View 객체화
        setContentView(binding.root)


    }

}