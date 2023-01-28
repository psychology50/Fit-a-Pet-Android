package likelion.project.fit_a_pet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import likelion.project.fit_a_pet.network.data.requests.LoginRequest
import likelion.project.fit_a_pet.network.data.requests.RegisterRequest
import likelion.project.fit_a_pet.model.repository.LoginState
import likelion.project.fit_a_pet.model.usecase.LoginUser
import likelion.project.fit_a_pet.model.repository.RegisterState
import likelion.project.fit_a_pet.model.usecase.RegisterUser
import likelion.project.fit_a_pet.utils.Resource
import javax.inject.Inject

// usecase에서 얻은 결과를 표시, 액세스 또는 사용할 모바일 화면과 결합하는 역할
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val registerUser: RegisterUser,
    private val loginUser: LoginUser
) : ViewModel() {
    // MutableLiveData: get, set 가능
    private val _registerState: MutableLiveData<RegisterState> = MutableLiveData()
    // LiveData : get()만 가능
    val registerState: LiveData<RegisterState> get() = _registerState

    private val _loginState: MutableLiveData<LoginState> = MutableLiveData()
    val loginState: LiveData<LoginState> get() = _loginState

    fun register(registerRequest: RegisterRequest) {
        registerUser(registerRequest).onEach {result ->
            when(result) {
                is Resource.Success -> {
                    _registerState.value = RegisterState(data = result.data)
                }
                is Resource.Loading -> {
                    _registerState.value = RegisterState(isLoading = true)
                }
                is Resource.Error -> {
                    _registerState.value = result.message?.let {
                        RegisterState(error = it)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    fun login(loginRequest: LoginRequest) {
        loginUser(loginRequest).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _loginState.value = LoginState(data = result.data)
                }
                is Resource.Loading -> {
                    _loginState.value = LoginState(isLoading = true)
                }
                is Resource.Error -> {
                    _loginState.value = result.message?.let {
                        LoginState(error = it)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}