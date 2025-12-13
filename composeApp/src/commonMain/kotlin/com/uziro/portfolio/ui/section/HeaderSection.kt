package com.uziro.portfolio.ui.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.repository.socialMediaList
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    onMenuSelected: (Int) -> Unit = {}
) {

    val uriHandler = LocalUriHandler.current
    var selectedMenu by remember { mutableStateOf("Home") }
    val menus = listOf("Home", "About", "Contact")

    TopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .background(Color.White)
            .padding(vertical = 8.dp),
        title = {
            Text(
                "Uziro",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
        },
        actions = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                menus.forEachIndexed { index, item ->
                    val isSelected = selectedMenu == item
                    Text(
                        text = item,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = if (isSelected) Color(0xFF6B63FF) else Color.Black,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        ),
                        modifier = Modifier
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable {
                                selectedMenu = item
                                onMenuSelected(index)
                            }
                    )
                }

                Spacer(Modifier.width(24.dp))

                // Social Icons
                Row(
                    modifier = Modifier.padding(end = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    socialMediaList.forEach { socialData ->
                        Box(
                            modifier = Modifier
                                .pointerHoverIcon(PointerIcon.Hand)
                                .clip(RoundedCornerShape(8.dp))
                                .border(
                                    width = 1.dp,
                                    color = Color.Black,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .background(Color.White)
                                .clickable {
                                    uriHandler.openUri(socialData.url)
                                }
                                .padding(8.dp)
                                .size(24.dp)
                        ) {
                            Image(
                                painter = painterResource(socialData.icon),
                                contentDescription = null,
                                modifier = Modifier
                            )
                        }
                    }
                }
            }
        }
    )
}
