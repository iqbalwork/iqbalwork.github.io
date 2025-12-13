package com.uziro.portfolio.ui.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.githublogo
import uziroportfolio.composeapp.generated.resources.linkedIn
import uziroportfolio.composeapp.generated.resources.wa

@Composable
fun ContactSection(
    modifier: Modifier = Modifier
) {

    val uriHandler = LocalUriHandler.current

    Box(
        modifier = modifier
            .fillMaxWidth()
//            .background(Color(0xFF212121)) // Dark background
            .padding(vertical = 80.dp, horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.widthIn(max = 600.dp)
        ) {
            Text(
                "Get in Touch",
                style = MaterialTheme.typography.labelLarge,
//                color = Color.White
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "Let's Build Something Great",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                ),
//                color = Color.White
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "I'm currently open to new opportunities and collaborations. If you have a project in mind or just want to connect, feel free to reach out.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
//                color = Color(0xFFBDBDBD) // Lighter gray for description
            )

            Spacer(Modifier.height(40.dp))

            Button(
                onClick = {
                    uriHandler.openUri("mailto:work.iqbalfauzi@gmail.com")
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333333))
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "work.iqbalfauzi@gmail.com",
                    color = Color.White
                )
            }

            Spacer(Modifier.height(40.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                ContactItem(
                    painter = painterResource(Res.drawable.linkedIn),
                ) {
                    uriHandler.openUri("https://www.linkedin.com/in/ifauzii/")
                }
                ContactItem(
                    painter = painterResource(Res.drawable.githublogo),
                ) {
                    uriHandler.openUri("https://github.com/iqbalwork")
                }
                ContactItem(
                    painter = painterResource(Res.drawable.wa),
                ) {
                    uriHandler.openUri("https://wa.me/6287822882668")
                }
            }
        }
    }
}

@Composable
fun ContactItem(
    painter: Painter,
    onClick: () -> Unit
) {
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
                onClick()
            }
            .padding(8.dp)
            .size(24.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
        )
    }
}
