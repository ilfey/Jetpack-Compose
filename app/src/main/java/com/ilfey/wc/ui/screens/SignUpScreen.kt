package com.ilfey.wc.ui.screens

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
import com.ilfey.wc.ui.components.BaseTextFiled
import com.ilfey.wc.ui.components.ConfirmButton
import com.ilfey.wc.ui.components.PasswordTextField
import com.ilfey.wc.ui.components.ScipButton
import com.ilfey.wc.util.validateEmail

@Composable
fun SignUpScreen(navController: NavController) {
    val ctx = LocalContext.current

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 42.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.splash_screen_logo),
            contentDescription = "World Cinema logo"
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            BaseTextFiled(label = "Имя", value = name) {
                name = it
            }

            BaseTextFiled(label = "Фамилия", value = surname) {
                surname = it
            }

            BaseTextFiled(label = "E-mail", value = email) {
                email = it
            }

            PasswordTextField(
                label = "Пароль",
                value = password,
            ) {
                password = it
            }

            PasswordTextField(
                label = "Повторите пароль",
                value = confirmPassword,
            ) {
                confirmPassword = it
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ConfirmButton(text = "Зарегистрироваться") {
//                TODO create registration
                val correctEmail = validateEmail(email)
                Log.d("[Validator]","email is $correctEmail")

                if (!correctEmail) {
                    Toast.makeText(ctx, "Введите правильный E-mail", Toast.LENGTH_SHORT).show()
                }
            }
            ScipButton(text = "У меня уже есть аккаунт") {
                navController.popBackStack()
            }
        }
    }
}