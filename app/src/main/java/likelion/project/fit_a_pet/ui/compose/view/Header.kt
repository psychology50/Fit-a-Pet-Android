package likelion.project.fit_a_pet.ui.compose.view

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.ui.activity.auth.RegisterActivity
import likelion.project.fit_a_pet.ui.theme.notosanskr

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@NonRestartableComposable
fun Header(
    msg: RegisterActivity.HeaderMessage,
    content: @Composable () -> Unit,
) {
    MaterialTheme {
        Scaffold(
            containerColor = Color(red = 0xF5, green = 0xF5, blue = 0xF5),
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(text = msg.logo, fontFamily = notosanskr, fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.ic_backbtn),
                                contentDescription = null,
                                tint = Color(red = 0xFF, green = 0xA8, blue = 0x00)
                            )
                        }

                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(red = 0xF5, green = 0xF5, blue = 0xF5, alpha = 0x00)
                    )
                )
            },
            content = { content() }
        )
    }
}