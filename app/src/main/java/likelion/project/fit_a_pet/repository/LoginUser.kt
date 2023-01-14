package likelion.project.fit_a_pet.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import likelion.project.fit_a_pet.module.data.requests.LoginRequest
import likelion.project.fit_a_pet.module.data.responses.LoginResponse
import likelion.project.fit_a_pet.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUser @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(request: LoginRequest): Flow<Resource<LoginResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.login(request)
            emit(Resource.Success(response))
        } catch (e:HttpException) {
            emit(Resource.Error("An error occurred"))
        } catch (e:IOException) {
            emit(Resource.Error("No internet connection"))
        }
    }
}