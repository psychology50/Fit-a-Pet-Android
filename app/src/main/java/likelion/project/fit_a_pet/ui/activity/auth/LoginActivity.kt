package likelion.project.fit_a_pet.ui.activity.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.base.BaseActivity
import likelion.project.fit_a_pet.databinding.ActLoginBinding
import likelion.project.fit_a_pet.network.data.requests.LoginRequest
import likelion.project.fit_a_pet.viewmodel.AuthViewModel

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActLoginBinding>(R.layout.act_login) {
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginBtn = binding.loginBtn

        loginBtn.setOnClickListener {
            val nickname = binding.edtId.text.toString()
            val pwd = binding.edtPwd.text.toString()

            if (nickname.isEmpty()) {
                showToast("Nickname required")
            } else if (pwd.isEmpty()) {
                showToast("Password required")
            } else {
                val loginRequest = LoginRequest(nickname, pwd)
                showToast("Loading...")
                authViewModel.login(loginRequest)
                observeLogin()
            }
        }
    }

    private fun observeLogin() {
        lifecycleScope.launch {
            authViewModel.loginState.collect { data ->
                if (data.data != null) {
                    showToast("Login successful")
                    finish()
                } else {
                    showToast("Login Failure ${data.error}")
                }
            }
        }
    }

    fun onBtnSignUp(v: View) {
        Log.e("startRegisterActivity", "clicked")
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}