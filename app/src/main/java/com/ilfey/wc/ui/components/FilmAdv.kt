package com.ilfey.wc.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ilfey.wc.R

@Composable
fun FilmAdv() {
    Box {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.splash_screen_logo),
            contentDescription = "World Cinema logo"
        )

        ConfirmButton(
            text = "Смотреть",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(vertical = 64.dp),
        ) {
//                TODO start film activity
        }
    }
}