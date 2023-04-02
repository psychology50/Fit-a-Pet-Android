package likelion.project.fit_a_pet.ui.compose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Content() {
    Surface(
        color = Color(red = 0xF5, green = 0xF5, blue = 0xF5, alpha = 0x00)
    ) {
//            val typography = MaterialTheme.typography
        val scrollState = rememberScrollState()
        Column(
            Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
//                    .background(
//                        color = Color(red = 0xF5, green = 0xF5, blue = 0xF5)
//                    )
                .padding(top = 56.dp),
        ) {
            RegisterBox()
            SubmitButton()
        }
    }
}