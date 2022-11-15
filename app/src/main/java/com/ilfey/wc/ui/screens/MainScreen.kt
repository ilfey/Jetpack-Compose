package com.ilfey.wc.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.ilfey.wc.tabs.TabItem
import com.ilfey.wc.ui.components.MovieAdv
import com.ilfey.wc.ui.components.Tabs
import com.ilfey.wc.ui.components.TabsContent
import com.ilfey.wc.ui.theme.background
import com.ilfey.wc.ui.theme.primary
import com.ilfey.wc.utils.AppConstants

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

//        TODO add List
        items(10) {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .heightIn(250.dp)
                        .align(Alignment.Center),
                    painter = rememberAsyncImagePainter("${AppConstants.BASEURL}img/600x350.png"), // TODO image from List item
                    contentDescription = "",
                )

                Image(
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .align(Alignment.Center)
                        .clickable {
//                        TODO play movie
                        },
                    imageVector = Icons.Filled.PlayArrow,
                    colorFilter = ColorFilter.tint(primary),
                    contentDescription = "Play",
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp),
                    text = "Movie title", // FIXME title from List item
                    fontSize = 16.sp,
                )
            }
        }
    }
}
