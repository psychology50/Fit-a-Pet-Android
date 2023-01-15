package likelion.project.fit_a_pet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import likelion.project.fit_a_pet.module.data.requests.LoginRequest
import likelion.project.fit_a_pet.module.data.requests.RegisterRequest
import likelion.project.fit_a_pet.model.repository.LoginState
import likelion.project.fit_a_pet.model.repository.LoginUser
import likelion.project.fit_a_pet.model.repository.RegisterState
import likelion.project.fit_a_pet.model.repository.RegisterUser
import likelion.project.fit_a_pet.utils.Resource
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val registerUser: RegisterUser,
    private val loginUser: LoginUser
) : ViewModel() {
    private val registerState: MutableLiveData<RegisterState> = MutableLiveData()
    val _registerState: LiveData<RegisterState>
        get() = registerState

    private val loginState: MutableLiveData<LoginState> = MutableLiveData()
    val _loginState: LiveData<LoginState>
        get() = loginState

    fun register(registerRequest: RegisterRequest) {
        registerUser(registerRequest).onEach {result ->
            when(result) {
                is Resource.Success -> {
                    registerState.value = RegisterState(data = result.data)
                }
                is Resource.Loading -> {
                    registerState.value = RegisterState(isLoading = true)
                }
                is Resource.Error -> {
                    registerState.value = result.message?.let {
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
                    loginState.value = LoginState(data = result.data)
                }
                is Resource.Loading -> {
                    loginState.value = LoginState(isLoading = true)
                }
                is Resource.Error -> {
                    loginState.value = result.message?.let {
                        LoginState(error = it)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}