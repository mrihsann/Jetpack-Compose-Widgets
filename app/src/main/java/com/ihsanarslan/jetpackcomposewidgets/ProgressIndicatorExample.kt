package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicatorExample() {
    var progress by remember { mutableFloatStateOf(0.3f) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic Circular Progress Indicator
        CircularProgressIndicator()

        // Linear Progress Indicator
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )

        // Determinate Progress Indicator
        Text("Determinate Progress: ${(progress * 100).toInt()}%")
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth()
        )

        // Colored Progress Indicator
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(48.dp)
        )

        // Track Color Progress Indicator
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )

        // Button to change progress
        Button(
            onClick = { progress = (progress + 0.1f).coerceIn(0f, 1f) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Increase Progress")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressIndicatorExamplePreview() {
    MaterialTheme {
        ProgressIndicatorExample()
    }
} 