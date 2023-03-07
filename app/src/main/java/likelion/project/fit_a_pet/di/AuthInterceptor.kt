package likelion.project.fit_a_pet.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import likelion.project.fit_a_pet.AuthApplication
import likelion.project.fit_a_pet.network.AuthAPI
import likelion.project.fit_a_pet.network.data.responses.LoginResponse
import likelion.project.fit_a_pet.utils.Constants.BASE_URL
import likelion.project.fit_a_pet.utils.NetworkException
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class AuthInterceptor @Inject constructor() : Interceptor {
    private val authApi: AuthAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthAPI::class.java)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

        // Get token from SharedPreference
        val token = AuthApplication.prefs.getAccessToken("access", "")
        if (token != "") { requestBuilder.header("Authorization", "JWT $token") }

        val response = chain.proceed(requestBuilder.build())
        if (response.code == 401) {
            runBlocking {
                val refreshToken = AuthApplication.prefs.getRefreshToken("refresh", "")
                if (refreshToken != "") {
                    val newToken = getNewToken(refreshToken)

                    if (newToken != null) {
                        AuthApplication.prefs.setAccessToken("access", newToken.access)

                        val newRequestBuilder = originalRequest.newBuilder()
                            .addHeader("Authorization", "JWT ${newToken.access}")
                        return@runBlocking chain.proceed(newRequestBuilder.build())
                    } else {
                       throw NetworkException(999, "refresh token expired")
                    }
                } else {
                    throw NetworkException(999, "can not find refresh token")
                }
            }
        }

        return response
    }

    private suspend fun getNewToken(refreshToken: String): LoginResponse? {
        return try {
            return authApi.refreshAccessToken("JWT $refreshToken")
        } catch (e: NetworkException) {
            null
        }
    }
}