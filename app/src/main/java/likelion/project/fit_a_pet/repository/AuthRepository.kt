package likelion.project.fit_a_pet.repository

import likelion.project.fit_a_pet.module.AuthAPI
import likelion.project.fit_a_pet.module.data.requests.LoginRequest
import likelion.project.fit_a_pet.module.data.requests.RegisterRequest
import likelion.project.fit_a_pet.module.data.responses.LoginResponse
import likelion.project.fit_a_pet.module.data.responses.RegisterResponse
import javax.inject.Inject

// 소스를 알지 못하는 viewModel 없이 소스에서 viewModel로 데이터 전달
class AuthRepository @Inject constructor(
    private val api: AuthAPI
) {
    suspend fun register(request: RegisterRequest): RegisterResponse = api.register(request)
    suspend fun login(request: LoginRequest): LoginResponse = api.login(request)
}