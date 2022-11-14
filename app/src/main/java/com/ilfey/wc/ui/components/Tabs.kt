package com.ilfey.wc.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilfey.wc.ui.theme.primary
import com.ilfey.wc.ui.theme.tabsContainer

@Composable
fun Tabs(tabs: List<String>, currentTab: MutableState<Int>) {
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

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
    ) {
//                TODO create list
    }
}