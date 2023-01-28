package likelion.project.fit_a_pet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import likelion.project.fit_a_pet.model.repository.AuthRepository
import likelion.project.fit_a_pet.network.AuthAPI
import javax.inject.Singleton

// 네트워크에서 Repository로 데이터가 흐른다.
// 다른 클래스가 해당 데이터를 사용할 수 있도록 Repository 액세스 모듈 생성
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton @Provides
    fun provideAuthRepository(api: AuthAPI): AuthRepository = AuthRepository(api)
}