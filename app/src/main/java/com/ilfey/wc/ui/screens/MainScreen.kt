package com.ilfey.wc.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilfey.wc.R
import com.ilfey.wc.ui.components.ConfirmButton
import com.ilfey.wc.ui.theme.background
import com.ilfey.wc.ui.theme.primary
import com.ilfey.wc.ui.theme.tabsContainer

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

        item {
            TabRow(
                modifier = Modifier
                    .padding(top = 6.dp)
                    .fillMaxWidth(),
                selectedTabIndex = currentTab.value,
                containerColor = tabsContainer,
                contentColor = primary,
                divider = @Composable {},
            ) {
                tabs.forEachIndexed { index, s ->
                    Tab(
                        selected = currentTab.value == index,
                        onClick = { currentTab.value = index },
                        selectedContentColor = primary,
                        unselectedContentColor = primary,
                    ) {
                        Text(
                            s,
                            modifier = Modifier.padding(vertical = 16.dp),
                            fontSize = 18.sp
                        )
                    }
                }
            }

        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
            ) {
//                TODO create in trend
            }
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
