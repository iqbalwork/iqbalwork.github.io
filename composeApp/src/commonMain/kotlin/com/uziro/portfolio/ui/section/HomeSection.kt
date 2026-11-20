package com.uziro.portfolio.ui.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Chat
import androidx.compose.material.icons.rounded.Android
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.repository.keyStats
import com.uziro.portfolio.data.repository.profileInfo
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.component.StatCard
import com.uziro.portfolio.ui.theme.statusColors
import org.jetbrains.compose.resources.painterResource
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.profile_photo

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeSection(modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current

    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (layoutInfo.isExpanded) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1.35f),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        HeroAvailabilityPill()
                        HeroIdentity(textAlign = TextAlign.Start)
                        HeroBio(textAlign = TextAlign.Start)
                        Spacer(modifier = Modifier.height(4.dp))
                        HeroActionRow(uriHandler = uriHandler, alignCenter = false)
                    }

                    Spacer(modifier = Modifier.width(40.dp))

                    Box(
                        modifier = Modifier.weight(0.75f),
                        contentAlignment = Alignment.Center
                    ) {
                        ExpressiveProfileFrame(sizeDp = 264)
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ExpressiveProfileFrame(sizeDp = if (layoutInfo.isCompact) 172 else 210)
                    HeroAvailabilityPill()
                    HeroIdentity(textAlign = TextAlign.Center)
                    HeroBio(textAlign = TextAlign.Center)
                    HeroActionRow(uriHandler = uriHandler, alignCenter = true)
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Key Impact Metrics Bento Grid
            if (layoutInfo.isExpanded) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    keyStats.forEachIndexed { index, stat ->
                        StatCard(
                            stat = stat,
                            toneIndex = index,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                        )
                    }
                }
            } else if (layoutInfo.isMedium) {
                Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    for (rowIndex in 0..1) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max),
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            val first = rowIndex * 2
                            StatCard(
                                stat = keyStats[first],
                                toneIndex = first,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                            )
                            StatCard(
                                stat = keyStats[first + 1],
                                toneIndex = first + 1,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                            )
                        }
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    keyStats.forEachIndexed { index, stat ->
                        StatCard(
                            stat = stat,
                            toneIndex = index,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ExpressiveProfileFrame(sizeDp: Int) {
    Box(contentAlignment = Alignment.BottomCenter) {
        Surface(
            shape = RoundedCornerShape(44.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier
                .size((sizeDp + 16).dp)
                .padding(bottom = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(36.dp))
            ) {
                Image(
                    painter = painterResource(Res.drawable.profile_photo),
                    contentDescription = profileInfo.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            tonalElevation = 2.dp
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Android,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "Android · KMP",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
private fun HeroAvailabilityPill() {
    Surface(
        shape = CircleShape,
        color = MaterialTheme.statusColors.successContainer,
        contentColor = MaterialTheme.statusColors.onSuccessContainer
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.statusColors.success)
            )
            Icon(
                imageVector = Icons.Rounded.LocationOn,
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
            Text(
                text = "Bandung, Indonesia · Open to KMP & Android",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Composable
private fun HeroIdentity(textAlign: TextAlign) {
    Column(
        horizontalAlignment = if (textAlign == TextAlign.Center) Alignment.CenterHorizontally else Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = profileInfo.name,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = textAlign
        )
        Text(
            text = profileInfo.title,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = textAlign
        )
    }
}

@Composable
private fun HeroBio(textAlign: TextAlign) {
    Text(
        text = profileInfo.summary,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = textAlign,
        modifier = Modifier.widthIn(max = 640.dp)
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HeroActionRow(
    uriHandler: UriHandler,
    alignCenter: Boolean
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (alignCenter) Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally) else Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            onClick = { uriHandler.openUri(profileInfo.cvUrl) },
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Description,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text("View CV")
        }

        FilledTonalButton(
            onClick = { uriHandler.openUri(profileInfo.whatsappUrl) },
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.Chat,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text("WhatsApp")
        }

        OutlinedButton(
            onClick = { uriHandler.openUri(profileInfo.githubUrl) },
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Code,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.size(6.dp))
            Text("GitHub")
        }

        OutlinedButton(
            onClick = { uriHandler.openUri(profileInfo.linkedinUrl) },
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text("LinkedIn")
        }
    }
}
