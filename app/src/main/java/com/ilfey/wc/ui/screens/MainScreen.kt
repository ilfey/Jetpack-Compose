package com.ilfey.wc.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilfey.wc.ui.components.FilmAdv
import com.ilfey.wc.ui.components.Tabs
import com.ilfey.wc.ui.theme.background
import com.ilfey.wc.ui.theme.primary

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun MainScreen() {

    val tabs = listOf("В тренде", "Новое", "Для вас")
    val currentTab = remember {
        mutableStateOf(0)
    }
    LazyColumn {
        item {
            FilmAdv()
        }

        item {
            Tabs(tabs = tabs, currentTab = currentTab)
        }

        stickyHeader {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = background,
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp, 16.dp, 16.dp, 16.dp),
                    text = "Вы смотрели",
                    color = primary,
                    fontSize = 24.sp,
                )
            }
        }

//        TODO create watched earlier
    }
}
