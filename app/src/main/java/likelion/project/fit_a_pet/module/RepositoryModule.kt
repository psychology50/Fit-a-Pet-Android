package likelion.project.fit_a_pet.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import likelion.project.fit_a_pet.model.repository.AuthRepository
import javax.inject.Singleton

// 네트워크 데이터에서 들어온 데이터. repository가 access할 수 있게 만든다.
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton @Provides
    fun provideAuthRepository(api: AuthAPI): AuthRepository = AuthRepository(api)
}