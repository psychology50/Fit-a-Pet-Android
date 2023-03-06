package likelion.project.fit_a_pet.page.view.auth

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import likelion.project.fit_a_pet.R
import likelion.project.fit_a_pet.base.BaseActivity
import likelion.project.fit_a_pet.databinding.ActLoginBinding

class RegisterActivity : BaseActivity<ActLoginBinding>(R.layout.act_register) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            Header {
//
//            }
//        }
    }

//    data class HeaderMessage(val logo: String, val option: String)
//
//    @Preview
//    @Composable
//    private fun Contents() {
//        MaterialTheme {
//            val typography = MaterialTheme.typography
//            val scrollState = rememberScrollState()
//            Column(
//                Modifier.verticalScroll(scrollState),
//            ) {
////                Header(HeaderMessage(stringResource(R.string.register), ""))
//
//            }
//        }
//    }
//
//    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//    @Composable
//    @NonRestartableComposable
//    fun Header(
//        msg: HeaderMessage? = null,
//        content: @Composable () -> Unit,
//    ) {
////        Scaffold(
////            topBar = {
////                TopAppBar(
////                    title = { Text(text = msg.logo) },
////                    navigationIcon = {
////                        Icon(
////                            imageVector = Icons.Default.ArrowBack,
////                            contentDescription = "Back Button"
////                        )
////                    }
////                )
////            }
////        ) { content() }
////        Row(
////            verticalAlignment = Alignment.CenterVertically,
////            horizontalArrangement = Arrangement.Center
////        ) {
////            Image(
////                painter = painterResource(R.drawable.ic_backbtn),
////                contentDescription = "back button"
////            )
////
////            // center
////            if (msg.logo == "") {
////                Image(
////                    painter = painterResource(R.drawable.ic_logo_black_background),
////                    contentDescription = "logo",
////                    modifier = Modifier.width(70.dp).height(70.dp)
////                )
////            } else {
////                Text(
////                    text = msg.logo,
////                    fontSize = 10.sp,
////                    textAlign = TextAlign.Center,
//////                    modifier = Modifier.width(78.dp).height(29.dp),
////                    fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold, FontWeight.Bold)),
////                    fontWeight = FontWeight.Bold,
////
////                )
////            }
////
////            if (msg.option != "") {
////                Image(
////                    painter = painterResource(R.drawable.ic_profile_background),
////                    contentDescription = "profile"
////                )
////            }
//    }
}