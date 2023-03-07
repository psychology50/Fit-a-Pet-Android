package likelion.project.fit_a_pet.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import likelion.project.fit_a_pet.network.AuthAPI
import likelion.project.fit_a_pet.utils.Constants.BASE_URL
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule{ // 어플리케이션 전체에서 사용되는 종속성
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
    fun provideInterceptor (
        @ApplicationContext context: Context,
        authInterceptor: AuthInterceptor,
        errorInterceptor: ErrorInterceptor,
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
//            .addInterceptor(authInterceptor)
            .addInterceptor(errorInterceptor)
            .build()
    }

    @Singleton @Provides
    fun provideAuthInterceptor() : Interceptor {
        return AuthInterceptor()
    }

    @Singleton @Provides
    fun provideErrorInterceptor() : Interceptor {
        return ErrorInterceptor()
    }
}