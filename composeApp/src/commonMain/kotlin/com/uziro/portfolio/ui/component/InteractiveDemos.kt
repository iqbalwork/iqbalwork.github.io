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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uziro.portfolio.ui.theme.PortfolioColors

@Composable
fun BoboboxIotPodDemo(modifier: Modifier = Modifier) {
    var isDoorUnlocked by remember { mutableStateOf(false) }
    var selectedColorIndex by remember { mutableStateOf(0) }
    var brightness by remember { mutableStateOf(0.75f) }
    var mqttLog by remember { mutableStateOf("MQTT Client: Connected to tcp://broker.bobobox.internal:8883 (QoS 1)") }

    val podColors = listOf(
        Color(0xFF00F0FF) to "Cyber Cyan",
        Color(0xFF8F7BFF) to "Sleep Violet",
        Color(0xFFFF9900) to "Sunset Warm",
        Color(0xFF00FF9D) to "Zen Emerald"
    )

    val activeLightColor = podColors[selectedColorIndex].first
    val animatedLightColor by animateColorAsState(
        targetValue = activeLightColor.copy(alpha = brightness),
        animationSpec = tween(400)
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(PortfolioColors.SurfaceContainer)
            .border(1.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(20.dp))
            .padding(20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "LIVE DEMO // BOBOBOX IOT SMART POD",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.Primary,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "MQTT Protocol Hardware Controller (Doors & Ambiance)",
                        fontSize = 12.sp,
                        color = PortfolioColors.OnSurfaceVariant
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(PortfolioColors.EmeraldSuccess.copy(alpha = 0.15f))
                        .border(1.dp, PortfolioColors.EmeraldSuccess.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "MQTT 99.9% LIVE",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.EmeraldSuccess
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Simulated Smart Pod Room Light Canvas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        Brush.radialGradient(
                            listOf(
                                animatedLightColor,
                                animatedLightColor.copy(alpha = 0.25f),
                                Color(0xFF0A0F1D)
                            )
                        )
                    )
                    .border(1.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(14.dp))
                    .padding(14.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.TopStart)
                ) {
                    Text(
                        text = "POD ROOM #402",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Ambiance: ${podColors[selectedColorIndex].second} • ${(brightness * 100).toInt()}% Brightness",
                        fontSize = 11.sp,
                        color = Color(0xFFE2E8F0)
                    )
                }

                // Door lock state badge
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isDoorUnlocked) PortfolioColors.EmeraldSuccess.copy(alpha = 0.25f) else PortfolioColors.RoseAlert.copy(alpha = 0.25f))
                        .border(1.dp, if (isDoorUnlocked) PortfolioColors.EmeraldSuccess else PortfolioColors.RoseAlert, RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = if (isDoorUnlocked) "DOOR: UNLOCKED [OPEN]" else "DOOR: LOCKED [SECURED]",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isDoorUnlocked) PortfolioColors.EmeraldSuccess else PortfolioColors.RoseAlert
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Interactive Controls Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Door Access:",
                        fontSize = 13.sp,
                        color = PortfolioColors.OnSurface,
                        fontWeight = FontWeight.Medium
                    )
                    Switch(
                        checked = isDoorUnlocked,
                        onCheckedChange = { checked ->
                            isDoorUnlocked = checked
                            mqttLog = if (checked)
                                "MQTT pub: bobo/pod-402/door/cmd {\"action\":\"UNLOCK\",\"token\":\"AUTH_VALID\"} -> ACK 200 (12ms)"
                            else
                                "MQTT pub: bobo/pod-402/door/cmd {\"action\":\"LOCK\",\"solenoid\":\"ENGAGED\"} -> ACK 200 (9ms)"
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = PortfolioColors.EmeraldSuccess,
                            checkedTrackColor = PortfolioColors.EmeraldSuccess.copy(alpha = 0.4f)
                        )
                    )
                }

                // Color Selector Dots
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Light:",
                        fontSize = 12.sp,
                        color = PortfolioColors.OnSurfaceVariant
                    )
                    podColors.forEachIndexed { index, (color, name) ->
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(color)
                                .border(
                                    if (selectedColorIndex == index) 2.5.dp else 0.dp,
                                    Color.White,
                                    CircleShape
                                )
                                .clickable {
                                    selectedColorIndex = index
                                    mqttLog = "MQTT pub: bobo/pod-402/light/preset {\"hex\":\"#${color.value.toString(16).take(6)}\",\"name\":\"$name\"}"
                                }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Brightness Slider
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Dimmer:",
                    fontSize = 12.sp,
                    color = PortfolioColors.OnSurfaceVariant
                )
                Slider(
                    value = brightness,
                    onValueChange = {
                        brightness = it
                        mqttLog = "MQTT pub: bobo/pod-402/light/dimmer {\"duty_cycle\":${(it * 100).toInt()}%}"
                    },
                    modifier = Modifier.weight(1f),
                    colors = SliderDefaults.colors(
                        thumbColor = PortfolioColors.Primary,
                        activeTrackColor = PortfolioColors.Primary
                    )
                )
                Text(
                    text = "${(brightness * 100).toInt()}%",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    color = PortfolioColors.OnSurface
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // MQTT Terminal Console
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(PortfolioColors.SurfaceContainerLowest)
                    .border(0.5.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Text(
                    text = "> $mqttLog",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    color = PortfolioColors.Secondary,
                    maxLines = 2
                )
            }
        }
    }
}

@Composable
fun SpatialVerseHighlightDemo(modifier: Modifier = Modifier) {
    var activeVerse by remember { mutableStateOf(2) }
    var deviceScale by remember { mutableStateOf(1.0f) }

    val sampleVerses = listOf(
        "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ" to "1. In the name of Allah, Most Gracious, Most Merciful",
        "الْحَمْدُ لِلَّهِ رَبِّ الْعَالَمِينَ" to "2. Praise be to Allah, the Lord of the worlds",
        "الرَّحْمَٰنِ الرَّحِيمِ" to "3. The Most Gracious, the Most Merciful",
        "مَالِكِ يَوْمِ الدِّينِ" to "4. Master of the Day of Judgment"
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(PortfolioColors.SurfaceContainer)
            .border(1.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(20.dp))
            .padding(20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "LIVE DEMO // SPATIAL VERSE HIGHLIGHTING",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.Secondary,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "Al Qosbah Dynamic X/Y Coordinate Scaling Canvas",
                        fontSize = 12.sp,
                        color = PortfolioColors.OnSurfaceVariant
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(PortfolioColors.Secondary.copy(alpha = 0.15f))
                        .border(1.dp, PortfolioColors.Secondary.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "PIXEL-PERFECT",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.Secondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Canvas rendering the dynamic bounding box calculation
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFF0B101E))
                    .border(1.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(14.dp))
                    .padding(10.dp)
            ) {
                Canvas(modifier = Modifier.matchParentSize()) {
                    val w = size.width
                    val h = size.height
                    val rowHeight = h / 4f

                    // Draw all verse bounding slots
                    for (i in 0..3) {
                        val topY = i * rowHeight
                        val isSelected = i == activeVerse

                        if (isSelected) {
                            // Draw dynamic highlight background
                            drawRoundRect(
                                color = PortfolioColors.Secondary.copy(alpha = 0.25f),
                                topLeft = Offset(10f * deviceScale, topY + 4f),
                                size = Size(w - (20f * deviceScale), rowHeight - 8f),
                                cornerRadius = CornerRadius(8f, 8f)
                            )
                            // Draw glowing boundary stroke
                            drawRoundRect(
                                color = PortfolioColors.Secondary,
                                topLeft = Offset(10f * deviceScale, topY + 4f),
                                size = Size(w - (20f * deviceScale), rowHeight - 8f),
                                cornerRadius = CornerRadius(8f, 8f),
                                style = Stroke(width = 1.5f)
                            )
                        } else {
                            // Inactive slot guide
                            drawRoundRect(
                                color = Color(0xFF1E293B).copy(alpha = 0.5f),
                                topLeft = Offset(10f * deviceScale, topY + 4f),
                                size = Size(w - (20f * deviceScale), rowHeight - 8f),
                                cornerRadius = CornerRadius(8f, 8f),
                                style = Stroke(width = 0.5f)
                            )
                        }
                    }
                }

                // Overlay Text Content
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    sampleVerses.forEachIndexed { index, (arabic, translation) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .clickable { activeVerse = index }
                                .padding(horizontal = 14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = translation,
                                fontSize = 11.sp,
                                color = if (index == activeVerse) Color.White else PortfolioColors.OnSurfaceVariant,
                                fontWeight = if (index == activeVerse) FontWeight.Bold else FontWeight.Normal
                            )
                            Text(
                                text = arabic,
                                fontSize = 12.sp,
                                color = if (index == activeVerse) PortfolioColors.Secondary else PortfolioColors.OnSurfaceVariant,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Scaling Slider Demo
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Screen DPI Scaling:",
                    fontSize = 12.sp,
                    color = PortfolioColors.OnSurfaceVariant
                )
                Slider(
                    value = deviceScale,
                    onValueChange = { deviceScale = it },
                    valueRange = 0.6f..1.4f,
                    modifier = Modifier.weight(1f),
                    colors = SliderDefaults.colors(
                        thumbColor = PortfolioColors.Secondary,
                        activeTrackColor = PortfolioColors.Secondary
                    )
                )
                Text(
                    text = "${(deviceScale * 100).toInt()}% Scale",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    color = PortfolioColors.OnSurface
                )
            }

            // Calculation formula footer
            Text(
                text = "TargetBox = Rect(x_orig * (${deviceScale.toString().take(4)}f), y_orig * (${deviceScale.toString().take(4)}f), w_orig * scaleX, h_orig * scaleY)",
                fontFamily = FontFamily.Monospace,
                fontSize = 10.sp,
                color = PortfolioColors.TextMuted
            )
        }
    }
}
