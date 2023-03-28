package likelion.project.fit_a_pet.ui.view.auth

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.ui.theme.notosanskr
import likelion.project.fit_a_pet.utils.compose.LabeledTextField

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Header(HeaderMessage(stringResource(R.string.register), "")) {
                Content()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewBaseActivityUI() {
        MaterialTheme {
            Header(HeaderMessage(stringResource(R.string.register), "")) {
                Content()
            }
        }
    }

    data class HeaderMessage(val logo: String, val option: String)

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    @NonRestartableComposable
    fun Header(
        msg: HeaderMessage,
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

    @Composable
    private fun Content() {
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RegisterBox() {
        var edit_id by remember { mutableStateOf("") }
        var edit_pw by remember { mutableStateOf("") }
        var edit_pw_check by remember { mutableStateOf("") }
        var edit_nickname by remember { mutableStateOf("") }
        var edit_email by remember { mutableStateOf("") }
        var edit_local by remember { mutableStateOf("") }
        var edit_local_prefix by remember { mutableStateOf("") }
        var edit_local_suffix by remember { mutableStateOf("") }

        Column(
            Modifier.fillMaxSize().padding(30.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // id input
            Spacer(Modifier.height(10.dp))
            Text(text = stringResource(R.string.id))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LabeledTextField(
                    label = stringResource(R.string.id),
                    value = edit_id,
                    onValueChange = { edit_id = it },
                    endPadding = 6.dp,
                    fraction = 0.8f
                )
                Button(
                    onClick = {},
                    modifier = Modifier.width(200.dp).height(36.dp).weight(0.7f),
                    enabled = false,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF, 0xA8, 0x00),
                        contentColor = Color.White,
                        disabledContainerColor = Color(0xC9, 0xC9, 0xC9),
                        disabledContentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = stringResource(R.string.duplicate), fontSize = 12.sp)
                }
            }

            // pwd input
            Spacer(Modifier.height(10.dp))
            Text(text = stringResource(R.string.password))
            LabeledTextField(
                label = stringResource(R.string.pwdText),
                value = edit_pw,
                onValueChange = { edit_id = it }
            )
            LabeledTextField(
                label = stringResource(R.string.check_pwd),
                value = edit_pw_check,
                onValueChange = { edit_id = it }
            )

            // nickname input
            Spacer(Modifier.height(10.dp))
            Text(text = stringResource(R.string.nickname))
            LabeledTextField(
                label = stringResource(R.string.nicknameText),
                value = edit_nickname,
                onValueChange = { edit_id = it }
            )

            // email input
            Spacer(Modifier.height(10.dp))
            Text(text = stringResource(R.string.email))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LabeledTextField(
                    label = stringResource(R.string.email),
                    value = edit_email,
                    onValueChange = { edit_id = it },
                    endPadding = 6.dp,
                    fraction = 0.8f
                )
                Button(
                    onClick = {},
                    modifier = Modifier.width(200.dp).height(36.dp).weight(1f),
                    enabled = false,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF, 0xA8, 0x00),
                        contentColor = Color.White,
                        disabledContainerColor = Color(0xC9, 0xC9, 0xC9),
                        disabledContentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = stringResource(R.string.duplicate), fontSize = 12.sp)
                }
            }

            // phone input
            Spacer(Modifier.height(10.dp))
            Text(text = stringResource(R.string.phone))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = edit_local,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    onValueChange = { edit_local = it },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(0.26f),
                )
                Text(text = stringResource(R.string.hyphen),
                    modifier = Modifier.weight(0.07f),
                    textAlign = TextAlign.Center)
                TextField(
                    value = edit_local_prefix,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    onValueChange = { edit_local_prefix = it },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(0.26f),
                )
                Text(text = stringResource(R.string.hyphen),
                    modifier = Modifier.weight(0.07f),
                    textAlign = TextAlign.Center)
                TextField(
                    value = edit_local_suffix,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    onValueChange = { edit_local_suffix = it },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(0.26f),
                )
            }
        }
    }

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
}