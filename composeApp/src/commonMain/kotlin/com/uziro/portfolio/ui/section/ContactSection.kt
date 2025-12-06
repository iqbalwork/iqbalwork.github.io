package com.uziro.portfolio.ui.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactSection(
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFE5E0F7)) // Light lilac background like Meelo
            .padding(vertical = 80.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        // Main Card
        Column(
            modifier = Modifier
                .width(900.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .border(
                    BorderStroke(1.dp, Color.Black),
                    RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 50.dp, vertical = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Label
            Text(
                "* CONTACT",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(50)
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )

            Spacer(Modifier.height(18.dp))

            // Title
            Text(
                "Got a project in mind?\nLet's get in touch.",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(40.dp))

            // ---- FORM FIELDS ----
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {

                Column(Modifier.weight(1f)) {
                    Text("Name", style = MaterialTheme.typography.labelMedium)
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = { Text("Your name *") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = textFieldColors()
                    )
                }

                Column(Modifier.weight(1f)) {
                    Text("Email", style = MaterialTheme.typography.labelMedium)
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text("Email address *") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = textFieldColors()
                    )
                }
            }

            Spacer(Modifier.height(28.dp))

            Column(Modifier.fillMaxWidth()) {
                Text("Message", style = MaterialTheme.typography.labelMedium)

                TextField(
                    value = message,
                    onValueChange = { message = it },
                    placeholder = { Text("Tell me about your project *") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    colors = textFieldColors(),
                )
            }

            Spacer(Modifier.height(40.dp))

            // Submit Button styled like Meelo
            Button(
                onClick = {},
                modifier = Modifier
                    .height(48.dp)
                    .width(120.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.Black),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text("Submit", color = Color.Black)
            }
        }
    }
}

@Composable
private fun textFieldColors() = TextFieldDefaults.colors(
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    disabledContainerColor = Color.Transparent,
    focusedIndicatorColor = Color.Black,
    unfocusedIndicatorColor = Color.Black,
    cursorColor = Color.Black,
)
