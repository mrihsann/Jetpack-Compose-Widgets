package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonExample() {
    var selectedOption by remember { mutableStateOf("Option 1") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic Radio Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Option 1")
            RadioButton(
                selected = selectedOption == "Option 1",
                onClick = { selectedOption = "Option 1" }
            )
        }

        // Radio Button with Label
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Option 2")
            RadioButton(
                selected = selectedOption == "Option 2",
                onClick = { selectedOption = "Option 2" }
            )
        }

        // Disabled Radio Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Option 3 (Disabled)")
            RadioButton(
                selected = selectedOption == "Option 3",
                onClick = { selectedOption = "Option 3" },
                enabled = false
            )
        }

        // Radio Button with Colors
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Option 4 (Colored)")
            RadioButton(
                selected = selectedOption == "Option 4",
                onClick = { selectedOption = "Option 4" },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary,
                    unselectedColor = MaterialTheme.colorScheme.outline
                )
            )
        }

        // Selected option text
        Text(
            text = "Selected: $selectedOption",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonExamplePreview() {
    MaterialTheme {
        RadioButtonExample()
    }
} 