package com.uziro.portfolio.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TextLabelButton(
    modifier: Modifier = Modifier,
    value: String,
    containerBackground: Color = MaterialTheme.colorScheme.primaryContainer,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = value,
        style = style,
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(20.dp))
            .background(color = containerBackground)
            .padding(vertical = 8.dp, horizontal = 12.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TextButtonPreview() {
    TextLabelButton(value = "* Hello!")
}