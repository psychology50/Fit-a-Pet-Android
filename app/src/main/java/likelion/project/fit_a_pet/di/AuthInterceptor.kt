package likelion.project.fit_a_pet.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import likelion.project.fit_a_pet.AuthApplication
import likelion.project.fit_a_pet.network.AuthAPI
import likelion.project.fit_a_pet.utils.Constants.BASE_URL
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
            val refreshToken = AuthApplication.prefs.getRefreshToken("refresh", "")
            if (refreshToken?.isNotEmpty() ?: false) {
                runBlocking {

                }
                // runBlocking이 더 직관적이지 않은가?
//                getNewToken(refreshToken)?.let {
//                    response
//                } ?: throw NetworkException(response.code, response.message);



                // 토큰 갱신용 리퀘스트
//                getNewToken(refreshToken) { accessToken, error ->
//                    if (error == null && accessToken != null) {
//                        AuthApplication.prefs.setAccessToken("access", accessToken)
//
//                        val newRequest = originalRequest.newBuilder()
//                            .header("Authorization", "JWT $accessToken")
//                            .build()
//                        return@getNewToken chain.proceed(newRequest)
//                    } else {
//                        throw NetworkException(401, "Failed to refresh access token")
//                    }
//                }
            }
        }

        return response
    }

    private fun getNewToken(refreshToken: String) {
        runBlocking {
            authApi.refreshAccessToken("JWT $refreshToken")
        }
    }

//    private fun getNewToken(refreshToken: String, callback: (accessToken: String?, error: Throwable?) -> Response) {
//        authApi.refreshAccessToken("JWT $refreshToken").enqueue(object: Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: retrofit2.Response<LoginResponse>) {
//                if (response.isSuccessful) {
//                    val newToken = response.body()?.access
//                    if (newToken != null) {
//                        callback(newToken, null)
//                    } else {
//                        callback(null, NetworkException(401, "Failed to refresh access token"))
//                    }
//                } else {
//                    callback(null, NetworkException(401, "Failed to refresh access token"))
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                callback(null, t)
//            }
//        })
//    }
}