package likelion.project.fit_a_pet.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider


/**
 * @sample [likelion.project.fit_a_pet.BaseActivityComposeSampleActivity]
 */
abstract class BaseActivityCompose<T : BaseViewModel> (
    val viewModel: Class<T>
) : ComponentActivity() {
//    protected abstract val viewModel: Class<T>

    @Composable
    protected abstract fun GetComposable(viewModel: T)

//    val composable: @Composable (viewModel: T) -> Unit
//        @Composable get() = @Composable {
//
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetComposable(ViewModelProvider(this)[viewModel])
//            composable.invoke(
//                ViewModelProvider(this)[viewModel]
//            )
        }
    }
}