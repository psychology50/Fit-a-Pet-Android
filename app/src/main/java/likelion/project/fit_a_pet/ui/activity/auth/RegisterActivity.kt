package likelion.project.fit_a_pet.ui.activity.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.base.BaseActivityCompose
import likelion.project.fit_a_pet.di.ErrorInterceptor
import likelion.project.fit_a_pet.model.repository.AuthRepository
import likelion.project.fit_a_pet.model.usecase.LoginUserUseCase
import likelion.project.fit_a_pet.model.usecase.RegisterUserUseCase
import likelion.project.fit_a_pet.network.AuthAPI
import likelion.project.fit_a_pet.ui.compose.view.Content
import likelion.project.fit_a_pet.ui.compose.view.Header
import likelion.project.fit_a_pet.utils.Constants
import likelion.project.fit_a_pet.viewmodel.AuthViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class RegisterActivity : BaseActivityCompose<AuthViewModel>(
//    composable = @Composable {viewModel ->
//        RegisterScreen(viewModel as AuthViewModel)
//    },//::RegisterScreen,
    viewModel = AuthViewModel::class.java
) {
    //    override val composable: (viewModel: AuthViewModel) -> Unit
//        @Composable get() = @Composable {
//
//        }
//    override val viewModel: Class<AuthViewModel>
//        get() = AuthViewModel::class.java

    @Composable
    override fun GetComposable(viewModel: AuthViewModel) {
        RegisterScreen(viewModel)
    }

}

data class HeaderMessage(val logo: String, val option: String)

@Composable
fun RegisterScreen(viewModel: AuthViewModel) {
    Header(HeaderMessage(stringResource(R.string.register), "")) {
        Content()
    }
}

@Preview
@Composable
private fun RegisterPreview() {
    val gson = GsonBuilder().create()

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val errorInterceptor = ErrorInterceptor()

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
//            .addInterceptor(authInterceptor)
        .addInterceptor(errorInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)

    val authApi = retrofit
        .build()
        .create(AuthAPI::class.java)

    val viewModel = AuthViewModel(
        RegisterUserUseCase(AuthRepository(
            authApi
        )),
        LoginUserUseCase(AuthRepository(
            authApi
        ))
    )
    RegisterScreen(viewModel)
}