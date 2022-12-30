package likelion.project.fit_a_pet.network

import okhttp3.Interceptor
import okhttp3.Response
import org.koin.dsl.ModuleDeclaration
import retrofit2.Retrofit
import java.io.IOException

object AuthAPI {
    private const val BASE_URL = "http://127.0.0.1:8000/"

    fun getAuthAPI(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient(AppInterceptor()))
            .build()
            .create()
    }

    fun okHttpClient()

    class AppInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {

            val newRequest = request().newBuilder()
                .addHeader("", "")
                .build()
            proceed(newRequest)
        }
    }
}