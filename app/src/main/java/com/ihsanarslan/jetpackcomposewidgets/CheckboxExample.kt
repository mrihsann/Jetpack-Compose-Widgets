package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(true) }
    var checked3 by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic Checkbox
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Basic Checkbox")
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }

        // Checkbox with Label
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Checked Checkbox")
            Checkbox(
                checked = checked2,
                onCheckedChange = { checked2 = it }
            )
        }

        // Disabled Checkbox
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Disabled Checkbox")
            Checkbox(
                checked = checked3,
                onCheckedChange = { checked3 = it },
                enabled = false
            )
        }

        // Checkbox with Colors
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Colored Checkbox")
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary,
                    uncheckedColor = MaterialTheme.colorScheme.outline
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxExamplePreview() {
    MaterialTheme {
        CheckboxExample()
    }
} 