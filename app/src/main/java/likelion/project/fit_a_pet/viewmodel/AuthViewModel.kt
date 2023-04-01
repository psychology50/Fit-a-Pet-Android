package likelion.project.fit_a_pet.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import likelion.project.fit_a_pet.AuthApplication
import likelion.project.fit_a_pet.base.BaseViewModel
import likelion.project.fit_a_pet.model.repository.LoginState
import likelion.project.fit_a_pet.model.repository.RegisterState
import likelion.project.fit_a_pet.model.usecase.LoginUserUseCase
import likelion.project.fit_a_pet.model.usecase.RegisterUserUseCase
import likelion.project.fit_a_pet.network.data.requests.LoginRequest
import likelion.project.fit_a_pet.network.data.requests.RegisterRequest
import likelion.project.fit_a_pet.utils.Resource
import javax.inject.Inject

// usecase에서 얻은 결과를 표시, 액세스 또는 사용할 모바일 화면과 결합하는 역할
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
    private val loginUserUseCase: LoginUserUseCase
) : BaseViewModel() {
    private val _registerState: MutableStateFlow<RegisterState> = MutableStateFlow(RegisterState())
    val registerState: StateFlow<RegisterState> get() = _registerState

    private val _loginState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> get() = _loginState

    fun register(registerRequest: RegisterRequest) {
        registerUserUseCase(registerRequest)
            .onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _registerState.value = RegisterState(data = result.data)
                    }
                    is Resource.Loading -> {}
                    is Resource.Error -> {
                        Log.e("RegisterInterceptor", "failed ViewModel ${result.message}")
                        _registerState.value = RegisterState(error = result.message)
                    }
                }
            }.launchIn(viewModelScope)
    }

    fun login(loginRequest: LoginRequest) {
        loginUserUseCase(loginRequest)
            .onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        val access = result.data?.access
                        val refresh = result.data?.refresh

                        if (access != null && refresh != null) {
                            AuthApplication.prefs.setAccessToken("access", access)
                            AuthApplication.prefs.setRefreshToken("refresh", refresh)
                        }

                       _loginState.value = LoginState(data = result.data)
                    }
                    is Resource.Loading -> {}
                    is Resource.Error -> {
                        Log.e("LoginInterceptor", "failed ViewModel ${result.message}")
                        _loginState.value = LoginState(error = result.message)
                    }
                }
            }.launchIn(viewModelScope)
    }
}