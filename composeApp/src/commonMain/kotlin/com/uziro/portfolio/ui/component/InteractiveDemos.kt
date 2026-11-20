package com.uziro.portfolio.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.LockOpen
import androidx.compose.material.icons.rounded.Sensors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.ui.theme.statusColors

@Composable
fun BoboboxIotPodDemo(modifier: Modifier = Modifier) {
    var isDoorUnlocked by remember { mutableStateOf(false) }
    var selectedColorIndex by remember { mutableStateOf(0) }
    var brightness by remember { mutableStateOf(0.75f) }
    var mqttLog by remember {
        mutableStateOf("MQTT Client: Connected to broker.bobobox.internal:8883 (QoS 1)")
    }

    val podColors = listOf(
        Color(0xFF00C4CC) to "Cyber Cyan",
        Color(0xFF7B61FF) to "Sleep Violet",
        Color(0xFFFF8A00) to "Sunset Warm",
        Color(0xFF00B87A) to "Zen Emerald"
    )

    val activeLightColor = podColors[selectedColorIndex].first
    val animatedLightColor by animateColorAsState(
        targetValue = activeLightColor.copy(alpha = brightness),
        animationSpec = tween(350)
    )

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Rounded.Sensors,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Column {
                        Text(
                            text = "Bobobox IoT Smart Pod",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "MQTT protocol controller (doors & ambiance)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.statusColors.successContainer,
                    contentColor = MaterialTheme.statusColors.onSuccessContainer
                ) {
                    Text(
                        text = "MQTT Live",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }

            // Smart Pod Room Light Preview Canvas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
                    .clip(MaterialTheme.shapes.large)
                    .background(
                        Brush.radialGradient(
                            listOf(
                                animatedLightColor,
                                animatedLightColor.copy(alpha = 0.25f),
                                Color(0xFF0E141C)
                            )
                        )
                    )
                    .padding(16.dp)
            ) {
                Column(modifier = Modifier.align(Alignment.TopStart)) {
                    Text(
                        text = "POD #402",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White
                    )
                    Text(
                        text = "${podColors[selectedColorIndex].second} · ${(brightness * 100).toInt()}% Brightness",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFE2E8F0)
                    )
                }

                Surface(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    shape = CircleShape,
                    color = if (isDoorUnlocked) {
                        MaterialTheme.statusColors.successContainer
                    } else {
                        MaterialTheme.colorScheme.errorContainer
                    },
                    contentColor = if (isDoorUnlocked) {
                        MaterialTheme.statusColors.onSuccessContainer
                    } else {
                        MaterialTheme.colorScheme.onErrorContainer
                    }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            imageVector = if (isDoorUnlocked) Icons.Rounded.LockOpen else Icons.Rounded.Lock,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = if (isDoorUnlocked) "Door unlocked" else "Door locked",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }

            // Interactive M3 Switch + Color Presets
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Pod door",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Switch(
                        checked = isDoorUnlocked,
                        onCheckedChange = { checked ->
                            isDoorUnlocked = checked
                            mqttLog = if (checked) {
                                "MQTT pub: bobo/pod-402/door {\"action\":\"UNLOCK\"} -> ACK 200 (12ms)"
                            } else {
                                "MQTT pub: bobo/pod-402/door {\"action\":\"LOCK\"} -> ACK 200 (9ms)"
                            }
                        },
                        thumbContent = {
                            Icon(
                                imageVector = if (isDoorUnlocked) Icons.Rounded.LockOpen else Icons.Rounded.Lock,
                                contentDescription = null,
                                modifier = Modifier.size(SwitchDefaults.IconSize)
                            )
                        }
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    podColors.forEachIndexed { index, (color, name) ->
                        val isSelected = selectedColorIndex == index
                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .clip(CircleShape)
                                .semantics { selected = isSelected }
                                .clickable(role = Role.RadioButton) {
                                    selectedColorIndex = index
                                    mqttLog = "MQTT pub: bobo/pod-402/light {\"preset\":\"$name\"}"
                                }
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .border(
                                        width = if (isSelected) 2.5.dp else 1.dp,
                                        color = if (isSelected) {
                                            MaterialTheme.colorScheme.onSurface
                                        } else {
                                            MaterialTheme.colorScheme.outlineVariant
                                        },
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                if (isSelected) {
                                    Icon(
                                        imageVector = Icons.Rounded.Check,
                                        contentDescription = "$name selected",
                                        tint = Color.White,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // M3 Dimmer Slider
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Dimmer",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Slider(
                    value = brightness,
                    onValueChange = {
                        brightness = it
                        mqttLog = "MQTT pub: bobo/pod-402/light/dimmer {\"duty\":${(it * 100).toInt()}%}"
                    },
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "${(brightness * 100).toInt()}%",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // MQTT Console Output
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.surfaceContainerLowest,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "> $mqttLog",
                    fontFamily = FontFamily.Monospace,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Composable
fun SpatialVerseHighlightDemo(modifier: Modifier = Modifier) {
    var activeVerse by remember { mutableStateOf(1) }
    var deviceScale by remember { mutableStateOf(1.0f) }

    val sampleVerses = listOf(
        Triple("Al-Fatihah 1:1", "Bismillahir-Rahmanir-Rahim", 84),
        Triple("Al-Fatihah 1:2", "Alhamdulillahi Rabbil-'Alamin", 168),
        Triple("Al-Fatihah 1:3", "Ar-Rahmanir-Rahim", 252),
        Triple("Al-Fatihah 1:4", "Maliki Yawmid-Din", 336)
    )

    val highlightColor = MaterialTheme.colorScheme.primary
    val inactiveStrokeColor = MaterialTheme.colorScheme.outlineVariant

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Rounded.AutoAwesome,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Column {
                        Text(
                            text = "Spatial Verse Highlighting",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Al Qosbah dynamic X/Y coordinate scaling canvas",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                ) {
                    Text(
                        text = "Pixel-Perfect",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }

            // Spatial Highlighting Canvas
            Surface(
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.surfaceContainerLowest,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
            ) {
                Box(modifier = Modifier.padding(10.dp)) {
                    Canvas(modifier = Modifier.matchParentSize()) {
                        val w = size.width
                        val h = size.height
                        val rowHeight = h / 4f
                        val inset = (10f * deviceScale).coerceIn(4f, w * 0.16f)

                        for (i in 0..3) {
                            val topY = i * rowHeight
                            val isSelected = i == activeVerse

                            if (isSelected) {
                                drawRoundRect(
                                    color = highlightColor.copy(alpha = 0.16f),
                                    topLeft = Offset(inset, topY + 3f),
                                    size = Size(w - (inset * 2f), rowHeight - 6f),
                                    cornerRadius = CornerRadius(12f, 12f)
                                )
                                drawRoundRect(
                                    color = highlightColor,
                                    topLeft = Offset(inset, topY + 3f),
                                    size = Size(w - (inset * 2f), rowHeight - 6f),
                                    cornerRadius = CornerRadius(12f, 12f),
                                    style = Stroke(width = 2f)
                                )
                            } else {
                                drawRoundRect(
                                    color = inactiveStrokeColor.copy(alpha = 0.45f),
                                    topLeft = Offset(inset, topY + 3f),
                                    size = Size(w - (inset * 2f), rowHeight - 6f),
                                    cornerRadius = CornerRadius(12f, 12f),
                                    style = Stroke(width = 1f)
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        sampleVerses.forEachIndexed { index, (ref, verseText, baseY) ->
                            val isSelected = index == activeVerse
                            val scaledX = (120 * deviceScale).toInt()
                            val scaledY = (baseY * deviceScale).toInt()
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(31.dp)
                                    .clip(MaterialTheme.shapes.small)
                                    .clickable { activeVerse = index }
                                    .padding(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "${index + 1}. $verseText",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                                    color = if (isSelected) {
                                        MaterialTheme.colorScheme.onSurface
                                    } else {
                                        MaterialTheme.colorScheme.onSurfaceVariant
                                    },
                                    maxLines = 1,
                                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    text = "$ref · (${scaledX}, ${scaledY})",
                                    fontFamily = FontFamily.Monospace,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Medium,
                                    color = if (isSelected) {
                                        MaterialTheme.colorScheme.primary
                                    } else {
                                        MaterialTheme.colorScheme.onSurfaceVariant
                                    },
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            }

            // Screen DPI Scaling Slider
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "DPI scale",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Slider(
                    value = deviceScale,
                    onValueChange = { deviceScale = it },
                    valueRange = 0.6f..1.4f,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "${(deviceScale * 100).toInt()}%",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Surface(
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.surfaceContainerLowest,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                val formattedScale = ((deviceScale * 100).toInt() / 100.0).toString()
                val activeBaseY = sampleVerses[activeVerse].third
                Text(
                    text = "Rect(x=120*$formattedScale, y=$activeBaseY*$formattedScale, scale=${(deviceScale * 100).toInt()}%)",
                    fontFamily = FontFamily.Monospace,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}
