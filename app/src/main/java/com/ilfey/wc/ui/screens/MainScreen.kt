package com.ilfey.wc.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.ilfey.wc.tabs.TabItem
import com.ilfey.wc.ui.components.MovieAdv
import com.ilfey.wc.ui.components.Tabs
import com.ilfey.wc.ui.components.TabsContent
import com.ilfey.wc.ui.theme.background
import com.ilfey.wc.ui.theme.primary

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Preview
@Composable
fun MainScreen() {
    val tabs = listOf(
        TabItem.InTrends,
        TabItem.New,
        TabItem.ForYou,
    )
    val pagerState = rememberPagerState()
    LazyColumn {
        item {
            MovieAdv()
        }

        item {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
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
