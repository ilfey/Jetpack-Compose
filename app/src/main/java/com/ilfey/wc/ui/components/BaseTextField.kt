package com.ilfey.wc.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import com.ilfey.wc.ui.theme.Shapes
import com.ilfey.wc.ui.theme.text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTextFiled(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        textStyle = TextStyle(
            color = Color(0xFFA8A8A8)
        ),
        shape = Shapes.small,
        label = {
            Text(
                text = label,
                color = text,
            )
        }
    )
}