package likelion.project.fit_a_pet.module

import likelion.project.fit_a_pet.module.data.requests.LoginRequest
import likelion.project.fit_a_pet.module.data.requests.RegisterRequest
import likelion.project.fit_a_pet.module.data.responses.LoginResponse
import likelion.project.fit_a_pet.module.data.responses.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {
    companion object{
        const val REGISTER = "users/signup/"
        const val LOGIN = "users/sighin/"
    }

    @POST(REGISTER)
    suspend fun register(@Body requestRequest: RegisterRequest): RegisterResponse

    @POST(LOGIN)
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}