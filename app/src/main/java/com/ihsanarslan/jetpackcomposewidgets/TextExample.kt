package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic Text
        Text(
            text = "Basic Text",
            style = MaterialTheme.typography.bodyLarge
        )

        // Colored Text
        Text(
            text = "Colored Text",
            color = Color.Blue,
            style = MaterialTheme.typography.bodyLarge
        )

        // Bold Text
        Text(
            text = "Bold Text",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        // Large Text
        Text(
            text = "Large Text",
            fontSize = 24.sp,
            style = MaterialTheme.typography.bodyLarge
        )

        // Centered Text
        Text(
            text = "Centered Text",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge
        )

        // Text with multiple styles
        Text(
            text = "Text with multiple styles",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Green,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextExamplePreview() {
    MaterialTheme {
        TextExample()
    }
} 