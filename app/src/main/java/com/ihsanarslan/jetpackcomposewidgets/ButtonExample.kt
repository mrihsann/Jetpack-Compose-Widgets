package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonExample() {
    var clickCount by remember { mutableIntStateOf(0) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic Button
        Button(
            onClick = { clickCount++ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Click me! Count: $clickCount")
        }

        // Outlined Button
        OutlinedButton(
            onClick = { clickCount++ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Outlined Button")
        }

        // Text Button
        TextButton(
            onClick = { clickCount++ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Text Button")
        }

        // Icon Button
        IconButton(
            onClick = { clickCount++ },
            modifier = Modifier.size(48.dp)
        ) {
            Text("🔍")
        }

        // Filled Tonal Button
        FilledTonalButton(
            onClick = { clickCount++ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Filled Tonal Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonExamplePreview() {
    MaterialTheme {
        ButtonExample()
    }
} 