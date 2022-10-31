package com.ilfey.wc.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ilfey.wc.R
import com.ilfey.wc.ui.components.ConfirmButton

@Composable
fun MainScreen() {
//        FilmAdv
//        ViewPager - В Тренде, Новое, Для Вас
//        NavBar

    Column {
        Box(
            modifier = Modifier.height(300.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.splash_screen_logo),
                contentDescription = "World Cinema logo"
            )
            ConfirmButton(
                text = "Смотреть",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 48.dp),
            ) {
//                TODO start film activity
            }
        }
    }
}
