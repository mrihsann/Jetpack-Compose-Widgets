package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownExample() {
    var expanded1 by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }
    var expanded3 by remember { mutableStateOf(false) }
    var selectedOption1 by remember { mutableStateOf("Option 1") }
    var selectedOption2 by remember { mutableStateOf("Option 1") }
    var selectedOption3 by remember { mutableStateOf("Option 1") }
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic Dropdown
        ExposedDropdownMenuBox(
            expanded = expanded1,
            onExpandedChange = { expanded1 = it }
        ) {
            OutlinedTextField(
                value = selectedOption1,
                onValueChange = {},
                readOnly = true,
                label = { Text("Basic Dropdown") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded1) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded1,
                onDismissRequest = { expanded1 = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOption1 = option
                            expanded1 = false
                        }
                    )
                }
            }
        }

        // Filled Dropdown
        ExposedDropdownMenuBox(
            expanded = expanded2,
            onExpandedChange = { expanded2 = it }
        ) {
            TextField(
                value = selectedOption2,
                onValueChange = {},
                readOnly = true,
                label = { Text("Filled Dropdown") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded2) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded2,
                onDismissRequest = { expanded2 = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOption2 = option
                            expanded2 = false
                        }
                    )
                }
            }
        }

        // Disabled Dropdown
        ExposedDropdownMenuBox(
            expanded = expanded3,
            onExpandedChange = { expanded3 = it }
        ) {
            OutlinedTextField(
                value = selectedOption3,
                onValueChange = {},
                readOnly = true,
                enabled = false,
                label = { Text("Disabled Dropdown") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded3) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded3,
                onDismissRequest = { expanded3 = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOption3 = option
                            expanded3 = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropdownExamplePreview() {
    MaterialTheme {
        DropdownExample()
    }
} 