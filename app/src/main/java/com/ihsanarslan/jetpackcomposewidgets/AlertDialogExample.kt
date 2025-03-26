package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogExample() {
    var showBasicDialog by remember { mutableStateOf(false) }
    var showCustomDialog by remember { mutableStateOf(false) }
    var showConfirmationDialog by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Button to show basic dialog
        Button(
            onClick = { showBasicDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Basic Dialog")
        }

        // Button to show custom dialog
        Button(
            onClick = { showCustomDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Custom Dialog")
        }

        // Button to show confirmation dialog
        Button(
            onClick = { showConfirmationDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Confirmation Dialog")
        }
    }

    // Basic Alert Dialog
    if (showBasicDialog) {
        AlertDialog(
            onDismissRequest = { showBasicDialog = false },
            title = { Text("Basic Dialog") },
            text = { Text("This is a basic alert dialog example.") },
            confirmButton = {
                TextButton(onClick = { showBasicDialog = false }) {
                    Text("OK")
                }
            }
        )
    }

    // Custom Alert Dialog
    if (showCustomDialog) {
        AlertDialog(
            onDismissRequest = { showCustomDialog = false },
            title = { Text("Custom Dialog") },
            text = {
                Column {
                    Text("This is a custom alert dialog with multiple buttons.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("You can customize the appearance and behavior.")
                }
            },
            confirmButton = {
                TextButton(onClick = { showCustomDialog = false }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { showCustomDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Confirmation Dialog
    if (showConfirmationDialog) {
        AlertDialog(
            onDismissRequest = { showConfirmationDialog = false },
            title = { Text("Confirmation") },
            text = { Text("Are you sure you want to proceed with this action?") },
            confirmButton = {
                TextButton(
                    onClick = { showConfirmationDialog = false },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showConfirmationDialog = false },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("No")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogExamplePreview() {
    MaterialTheme {
        AlertDialogExample()
    }
} 