package likelion.project.fit_a_pet.ui.compose.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.ui.theme.notosanskr

@Composable
fun SubmitButton() {
    Row(
        Modifier.fillMaxSize().padding(30.dp)
    ) {
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth().height(60.dp),
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF, 0xA8, 0x00),
                contentColor = Color.White,
                disabledContainerColor = Color(0xC9, 0xC9, 0xC9),
                disabledContentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.register),
                fontFamily = notosanskr,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}