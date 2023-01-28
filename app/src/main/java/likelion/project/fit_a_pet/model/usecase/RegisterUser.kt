package likelion.project.fit_a_pet.model.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import likelion.project.fit_a_pet.model.repository.AuthRepository
import likelion.project.fit_a_pet.network.data.requests.RegisterRequest
import likelion.project.fit_a_pet.network.data.responses.RegisterResponse
import likelion.project.fit_a_pet.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

// UseCase : Application 비지니스 로직을 ViewModel. 최종 사용자가 응용 프로그램과 상호작용하는 방법 지정
class RegisterUser @Inject constructor(private val repository: AuthRepository) {
    // Kotlin invoke 연산자 : 이름 없이 호출된다. == 메서드 이름없이 호출할 수 있다.
    // 람다는 invoke 함수를 가진 객체다.

    // Kotlin Flow는 suspend function을 보완하기 위한 객체.
    // suspend fun이 하나의 결과물을 던진다면, flow로 여러 개의 결과를 원하는 형식으로 던질 수 있다.
    // suspend fun과 동일하게 비동기로 동작하며 cold stream을 지원한다.
    operator fun invoke(request: RegisterRequest): Flow<Resource<RegisterResponse>> = flow {
        try {
            emit(Resource.Loading()) // emit: flow에서 데이터를 전달하기 위한 함수
            val response = repository.register(request)
            emit(Resource.Success(response))
        } catch(e: HttpException) {
            emit(Resource.Error("An error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Check internet connection"))
        }
    }
}