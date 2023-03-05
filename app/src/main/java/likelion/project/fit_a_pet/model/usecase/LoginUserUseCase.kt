package likelion.project.fit_a_pet.model.usecase

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import likelion.project.fit_a_pet.model.repository.AuthRepository
import likelion.project.fit_a_pet.network.data.requests.LoginRequest
import likelion.project.fit_a_pet.network.data.responses.LoginResponse
import likelion.project.fit_a_pet.utils.NetworkException
import likelion.project.fit_a_pet.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(request: LoginRequest): Flow<Resource<LoginResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.login(request)
            emit(Resource.Success(response))
        } catch (e:NetworkException) {
            Log.e("LoginInterceptor", "Login failed exception: ${e.message}")
            emit(Resource.Error(e.message))
        }
    }
}