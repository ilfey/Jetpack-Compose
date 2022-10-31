package com.ilfey.wc.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ilfey.wc.ui.theme.Shapes

@Composable
fun ConfirmButton(text: String, modifier: Modifier = Modifier.fillMaxWidth(), onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = Shapes.small,
    ) {
        Text(text = text)
    }
}