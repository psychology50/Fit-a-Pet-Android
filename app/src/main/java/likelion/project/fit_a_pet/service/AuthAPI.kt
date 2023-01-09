package likelion.project.fit_a_pet.service

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.dsl.ModuleDeclaration
import retrofit2.Retrofit
import retrofit2.http.Body
import java.io.IOException

interface AuthApiService {
    suspend fun login(
//        @Body auth: Auth,
    )
}