package likelion.project.fit_a_pet.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import likelion.project.fit_a_pet.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
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
    fun provideAuthService(retrofit: Retrofit.Builder): AuthAPI { // API에서 인스턴스 가져온다.
        return retrofit
            .build()
            .create(AuthAPI::class.java)
    }

    @Singleton @Provides
    fun provideInterceptor (
        @ApplicationContext context: Context
    ): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}