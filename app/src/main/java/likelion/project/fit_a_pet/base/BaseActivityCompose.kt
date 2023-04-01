package likelion.project.fit_a_pet.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider



/**
 * @sample [likelion.project.fit_a_pet.BaseActivityComposeSampleActivity]
 */
abstract class BaseActivityCompose<T : BaseViewModel>(
    var composable: @Composable (viewModel: T)->Unit,
    val viewModel: Class<T>,
) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            composable.invoke(
                ViewModelProvider(this)[viewModel]
//                viewModel<T>()
            )
            //BaseActivityUI()
        }
    }
}