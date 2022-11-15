package com.ilfey.wc.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.ilfey.wc.tabs.TabItem
import com.ilfey.wc.ui.theme.primary
import com.ilfey.wc.ui.theme.tabsContainer
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    TabRow(
        modifier = Modifier
            .padding(top = 6.dp)
            .fillMaxWidth(),
        selectedTabIndex = pagerState.currentPage,
        containerColor = tabsContainer,
        contentColor = primary,
        divider = @Composable {},
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                selectedContentColor = primary,
                unselectedContentColor = primary,
                text = {
                    Text(
                        tab.title,
                        modifier = Modifier.padding(vertical = 16.dp),
                        fontSize = 18.sp,
                    )
                },
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        count = tabs.size,
        userScrollEnabled = false,
    ) { index -> tabs[index].screen() }
}