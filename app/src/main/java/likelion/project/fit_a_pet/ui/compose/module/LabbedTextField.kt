package likelion.project.fit_a_pet.utils.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabeledTextField(
    label: String = "",
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasword: Boolean = false,
    endPadding: Dp = 0.dp,
    fraction: Float = 1f,
    condition: Boolean = false,
    weight: Float = 0f,
) {
    TextField(
        value = value,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        onValueChange = onValueChange,
        placeholder = { Text(text = label) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(fraction).padding(end = endPadding),
//        textStyle = TextStyle.Default.copy(
//            fontFamily = notosanskr,
//            fontWeight = FontWeight.Normal,
//        )

    )
}