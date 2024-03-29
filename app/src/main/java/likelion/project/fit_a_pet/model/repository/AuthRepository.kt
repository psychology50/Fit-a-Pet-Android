package likelion.project.fit_a_pet.model.repository

import android.content.Context
import android.content.SharedPreferences
import likelion.project.fit_a_pet.AuthApplication
import likelion.project.fit_a_pet.network.AuthAPI
import likelion.project.fit_a_pet.network.data.requests.LoginRequest
import likelion.project.fit_a_pet.network.data.requests.RegisterRequest
import likelion.project.fit_a_pet.network.data.responses.LoginResponse
import likelion.project.fit_a_pet.network.data.responses.RegisterResponse
import likelion.project.fit_a_pet.utils.NetworkException
import retrofit2.Call
import java.lang.Exception
import javax.inject.Inject
import javax.security.auth.login.LoginException

// repository class가 인증 데이터를 network로 부터 가져와 viewmodel에 전달
// 소스를 알지 못하는 viewModel 없이 소스에서 viewModel로 데이터 전달
class AuthRepository @Inject constructor(
    private val api: AuthAPI
) {
    suspend fun register(request: RegisterRequest): RegisterResponse {
        try {
            return api.register(request)
        } catch (e: NetworkException) {
            throw NetworkException(e.code, e.message)
        }
    }

    suspend fun login(request: LoginRequest): LoginResponse {
        try {
            return api.login(request)
        } catch (e: NetworkException) {
            throw NetworkException(e.code, e.message)
        }
    }

    suspend fun refreshAccessToken(refresh: String): LoginResponse = api.refreshAccessToken(refresh)
}