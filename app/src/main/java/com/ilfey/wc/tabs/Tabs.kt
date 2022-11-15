package com.ilfey.wc.tabs

import androidx.compose.runtime.Composable
import com.ilfey.wc.ui.components.tabs.RowMovieList


sealed class TabItem(var title: String, var screen: @Composable () -> Unit) {
    object InTrends : TabItem("В тренде", { RowMovieList() })
    object New : TabItem("Новое", { RowMovieList() })
    object ForYou : TabItem("Для вас", { RowMovieList() })
}
