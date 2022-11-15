package com.ilfey.wc.tabs

import androidx.compose.runtime.Composable


sealed class TabItem(var title: String, var screen: @Composable () -> Unit) {
    object InTrends : TabItem("В тренде", { })
    object New : TabItem("Новое", { })
    object ForYou : TabItem("Для вас", { })
}
