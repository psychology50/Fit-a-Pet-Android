package likelion.project.fit_a_pet.model.repository

import likelion.project.fit_a_pet.network.AuthAPI
import likelion.project.fit_a_pet.network.data.requests.LoginRequest
import likelion.project.fit_a_pet.network.data.requests.RegisterRequest
import likelion.project.fit_a_pet.network.data.responses.LoginResponse
import likelion.project.fit_a_pet.network.data.responses.RegisterResponse
import javax.inject.Inject

// repository class가 인증 데이터를 network로 부터 가져와 viewmodel에 전달
// 소스를 알지 못하는 viewModel 없이 소스에서 viewModel로 데이터 전달
class AuthRepository @Inject constructor(
    private val api: AuthAPI
) {
    suspend fun register(request: RegisterRequest): RegisterResponse = api.register(request)
    suspend fun login(request: LoginRequest): LoginResponse = api.login(request)
}