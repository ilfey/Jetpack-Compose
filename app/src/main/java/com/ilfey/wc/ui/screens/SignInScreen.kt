package com.ilfey.wc.ui.components.sign_in

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ilfey.wc.R
import com.ilfey.wc.navigation.Routes
import com.ilfey.wc.ui.components.BaseTextFiled
import com.ilfey.wc.ui.components.ConfirmButton
import com.ilfey.wc.ui.components.PasswordTextField
import com.ilfey.wc.ui.components.ScipButton
import com.ilfey.wc.util.validateEmail

@Composable
fun SignInScreen(navController: NavController) {
    val ctx = LocalContext.current

    var email by remember { mutableStateOf("") }
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
            BaseTextFiled(label = "E-mail", value = email) {
                email = it
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
//                TODO create sign in
                val correctEmail = validateEmail(email)
                Log.d("[Validator]","email is $correctEmail")

                if (!correctEmail) {
                    Toast.makeText(ctx, "Введите правильный E-mail", Toast.LENGTH_SHORT).show()
                }

            }
            ScipButton(text = "Регистрация") {
                navController.navigate(Routes.SignUpScreen.route)
            }
        }
    }
}