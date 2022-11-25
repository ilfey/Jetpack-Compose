package com.ilfey.wc.ui.screens

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ilfey.wc.R
import com.ilfey.wc.navigation.AuthRoutes
import com.ilfey.wc.network.model.LoginBody
import com.ilfey.wc.ui.activities.MainActivity
import com.ilfey.wc.ui.components.BaseTextFiled
import com.ilfey.wc.ui.components.ConfirmButton
import com.ilfey.wc.ui.components.PasswordTextField
import com.ilfey.wc.ui.components.ScipButton
import com.ilfey.wc.util.validateEmail
import com.ilfey.wc.viewmodel.SignInViewModel
import okhttp3.internal.userAgent

@Composable
fun SignInScreen(
    viewModel: SignInViewModel,
    callback: (String) -> Unit
) {
    val ctx = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 42.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 32.dp, 0.dp, 0.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.splash_screen_logo),
            contentDescription = "World Cinema logo"
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            BaseTextFiled(label = "Логин", value = username) {
                username = it
            }

            PasswordTextField(
                label = "Пароль",
                value = password,
            ) {
                password = it
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ConfirmButton(text = "Войти") {
//                TODO check connection

                viewModel.login(
                    LoginBody(
                        username = username,
                        password = password,
                    )
                ) {
                    if (it) {
                        val intent = Intent(ctx, MainActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        ctx.startActivity(intent)
                    } else {
                        Toast.makeText(
                            ctx,
                            "Проверьте правильность логина и пароля.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            ScipButton(text = "Регистрация") {
                callback(AuthRoutes.SignUpScreen.route)
            }
        }
    }
}