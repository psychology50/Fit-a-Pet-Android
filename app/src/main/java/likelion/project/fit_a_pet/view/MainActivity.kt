package likelion.project.fit_a_pet.view

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import likelion.project.fit_a_pet.R

class MainActivity : AppCompatActivity() {
//    private val viewModel by viewModels<MainViewModel>()
    private var edt_id: EditText? = null;
    private var edt_pwd: EditText? = null;
    private var pref: SharedPreferences? = null;

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        edt_id = findViewById(R.id.edt_id)
        edt_pwd = findViewById(R.id.edt_pwd)

        pref = getSharedPreferences("userInfo", MODE_PRIVATE)

        val btn_login: Button = findViewById(R.id.loginBtn)
        btn_login.setOnClickListener{ _ ->
            run {
                val editor: SharedPreferences.Editor = pref!!.edit()

                editor.putString("userId", edt_id!!.text.toString())
                editor.putString("userPwd", edt_pwd!!.text.toString())
                editor.commit()
                getPreferences()
            }
        }

    }

    private fun getPreferences() {
        TODO("Not yet implemented")
    }


}