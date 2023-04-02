package likelion.project.fit_a_pet

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import likelion.project.fit_a_pet.base.BaseActivityCompose
import likelion.project.fit_a_pet.base.BaseViewModel

@Preview(showBackground = true)
@Composable
fun MyActivityPreview() {
    MyActivityScreen(MyActivityViewModel())
}

@Composable
fun MyActivityScreen(viewModel: MyActivityViewModel) {}

class MyActivityViewModel : BaseViewModel() {}

class BaseActivityComposeSampleActivity : BaseActivityCompose<MyActivityViewModel>(
//    composable = ::MyActivityScreen,
    viewModel = MyActivityViewModel::class.java
) {
    @Composable
    override fun GetComposable(viewModel: MyActivityViewModel) {
        MyActivityScreen(viewModel)
    }
}