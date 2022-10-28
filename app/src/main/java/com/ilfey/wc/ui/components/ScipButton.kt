package com.ilfey.wc.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ilfey.wc.ui.theme.Shapes

@Composable
fun ScipButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = Shapes.small,
    ) {
        Text(text = text)
    }
}