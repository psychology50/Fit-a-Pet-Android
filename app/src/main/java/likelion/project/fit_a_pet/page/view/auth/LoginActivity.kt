package likelion.project.fit_a_pet.page.view.auth

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.base.BaseActivity
import likelion.project.fit_a_pet.databinding.ActLoginBinding
import likelion.project.fit_a_pet.module.data.requests.LoginRequest
import likelion.project.fit_a_pet.viewmodel.AuthViewModel

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActLoginBinding>(R.layout.act_login) {
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginBtn = binding.loginBtn

        loginBtn.setOnClickListener {
            val nickname = binding.edtId.toString()
            val pwd = binding.edtPwd.toString()

            if (nickname.isEmpty()) {
                showToast("Nickname required")
            } else if (pwd.isEmpty()) {
                showToast("Password required")
            } else {
                val loginRequest = LoginRequest(nickname, pwd)
                authViewModel.login(loginRequest)
                observeLogin()
            }
        }
    }

    private fun observeLogin() {
        authViewModel._loginState.observe(this) {data ->
            when {
                data.isLoading -> {
                    showToast("Loading...")
                }
                data.data != null -> {
                    showToast("Login successful $data")

                }
                else -> {
                    showToast("Login Failure ${data.error}")
                }
            }
        }
    }
}