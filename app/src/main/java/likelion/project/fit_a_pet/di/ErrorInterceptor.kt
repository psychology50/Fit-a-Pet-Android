package likelion.project.fit_a_pet.di

import android.util.Log
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import likelion.project.fit_a_pet.utils.NetworkException
import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONObject
import javax.inject.Inject
import kotlin.jvm.Throws

@Module
@InstallIn(SingletonComponent::class)
class ErrorInterceptor @Inject constructor() : Interceptor {
//    @Throws(NetworkException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        // exception handler for network
        if (!response.isSuccessful) {
            Log.e("LoginInterceptor", "Login failed: ${response.code}")
            Log.e("LoginInterceptor", "Login failed: ${response.message}")
            throw NetworkException(response.code, response.message)
        }

        // exception handler for non-json type data
        response.extractResponseJson()

        return response
    }

    private fun Response.extractResponseJson(): JSONObject {
//        val jsonString = this.body?.string() ?: EMPTY_JSON
        val jsonString = this.peekBody(Long.MAX_VALUE).string() ?: EMPTY_JSON
        return try {
            JSONObject(jsonString)
        } catch (e: Exception) {
            Log.e("LoginInterceptor", "not json response $jsonString")
            throw NetworkException(999, "not json type")
        }
    }

    companion object {
        private const val EMPTY_JSON = "{}"
    }
}