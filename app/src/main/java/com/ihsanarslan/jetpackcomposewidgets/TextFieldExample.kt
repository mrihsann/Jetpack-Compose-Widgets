package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldExample() {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var multilineText by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic TextField
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Basic TextField") },
            modifier = Modifier.fillMaxWidth()
        )

        // Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        // Multiline TextField
        OutlinedTextField(
            value = multilineText,
            onValueChange = { multilineText = it },
            label = { Text("Multiline TextField") },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            minLines = 3
        )

        // Filled TextField
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Filled TextField") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldExamplePreview() {
    MaterialTheme {
        TextFieldExample()
    }
} 