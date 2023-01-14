package likelion.project.fit_a_pet.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import likelion.project.fit_a_pet.module.data.requests.RegisterRequest
import likelion.project.fit_a_pet.module.data.responses.RegisterResponse
import likelion.project.fit_a_pet.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RegisterUser @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(request: RegisterRequest): Flow<Resource<RegisterResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.register(request)
            emit(Resource.Success(response))
        } catch(e: HttpException) {
            emit(Resource.Error("An error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Check internet connection"))
        }
    }
}