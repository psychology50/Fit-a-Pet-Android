package likelion.project.fit_a_pet.network

import likelion.project.fit_a_pet.network.data.requests.LoginRequest
import likelion.project.fit_a_pet.network.data.requests.RegisterRequest
import likelion.project.fit_a_pet.network.data.responses.LoginResponse
import likelion.project.fit_a_pet.network.data.responses.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

// API End-Point
interface AuthAPI {
    companion object{
        const val REGISTER = "users/signup/"
        const val LOGIN = "users/signin/"
        const val REFRESH = "users/signin/refresh"
    }

    @POST(REGISTER) // 요청 URL 명시, payload 작성
    suspend fun register(@Body requestRequest: RegisterRequest): RegisterResponse

    @POST(LOGIN)
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST(REFRESH)
    suspend fun refreshAccessToken(@Header("Authorization") token: String): LoginResponse
}