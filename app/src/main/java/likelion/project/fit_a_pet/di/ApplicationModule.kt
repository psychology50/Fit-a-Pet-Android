package likelion.project.fit_a_pet.di

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import likelion.project.fit_a_pet.model.repository.LoginState
import likelion.project.fit_a_pet.network.AuthAPI
import likelion.project.fit_a_pet.utils.Constants.BASE_URL
import likelion.project.fit_a_pet.utils.NetworkException
import likelion.project.fit_a_pet.utils.Resource
import likelion.project.fit_a_pet.viewmodel.AuthViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.internal.http2.Header
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule { // 어플리케이션 전체에서 사용되는 종속성
    @Singleton @Provides
    fun provideGsonBuilder(): Gson { // Kotlin 객체 <-> JSON
        return GsonBuilder().create()
    }

    @Singleton @Provides
    fun provideRetrofit( // 원격 API에 네트워크 클래스 생성
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
    }

    @Singleton @Provides
    fun provideAuthService(retrofit: Retrofit.Builder): AuthAPI { // Retrofit으로 구축된 API 인스턴스에서 가져온다.
        return retrofit
            .build()
            .create(AuthAPI::class.java)
    }

    @Singleton @Provides
    fun provideInterceptor ( // API 요청을 가로채고 응답을 콘솔에 기록. (디버깅용)
        @ApplicationContext context: Context
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val errorInterceptor = Interceptor { chain ->
            val request = chain.request()
            val response = chain.proceed(request)

//            response.extractResponseJson()

            if (!response.isSuccessful) {
                Log.e("LoginInterceptor", "Login failed: ${response.code}")
                Log.e("LoginInterceptor", "Login failed: ${response.message}")

                throw NetworkException(response.message)
            }
            response
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(errorInterceptor)
            .build()
    }

    private fun Response.extractResponseJson(): JSONObject {
        val jsonString = this.body?.string() ?: EMPTY_JSON
        return try {
            JSONObject(jsonString)
        } catch (e: Exception) {
            Log.e("LoginInterceptor", "not json response $jsonString")
            throw NetworkException(jsonString)
        }
    }

    companion object {
        private const val EMPTY_JSON = "{}"
    }
}