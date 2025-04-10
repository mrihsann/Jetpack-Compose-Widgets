package com.example.jetpackcomposewidgets.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnackbarExample() {
    var snackbarHostState = remember { SnackbarHostState() }
    var showSnackbar by remember { mutableStateOf(false) }
    
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Content
            Text(
                text = "Snackbar Example",
                style = MaterialTheme.typography.headlineMedium
            )
            
            // Basic Snackbar Button
            Button(
                onClick = {
                    showSnackbar = true
                    snackbarHostState.showSnackbar(
                        message = "This is a basic snackbar",
                        duration = SnackbarDuration.Short
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Show Basic Snackbar")
            }
            
            // Snackbar with Action Button
            Button(
                onClick = {
                    showSnackbar = true
                    snackbarHostState.showSnackbar(
                        message = "This is a snackbar with action",
                        duration = SnackbarDuration.Short,
                        withDismissAction = true,
                        actionLabel = "Action"
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Show Snackbar with Action")
            }
            
            // Long Duration Snackbar
            Button(
                onClick = {
                    showSnackbar = true
                    snackbarHostState.showSnackbar(
                        message = "This is a long duration snackbar",
                        duration = SnackbarDuration.Long
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Show Long Duration Snackbar")
            }
            
            // Indefinite Duration Snackbar
            Button(
                onClick = {
                    showSnackbar = true
                    snackbarHostState.showSnackbar(
                        message = "This is an indefinite duration snackbar",
                        duration = SnackbarDuration.Indefinite,
                        withDismissAction = true
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Show Indefinite Duration Snackbar")
            }
            
            // Custom Snackbar
            Button(
                onClick = {
                    showSnackbar = true
                    snackbarHostState.showSnackbar(
                        message = "This is a custom snackbar",
                        duration = SnackbarDuration.Short,
                        withDismissAction = true,
                        actionLabel = "Custom Action",
                        actionOnNewLine = true
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Show Custom Snackbar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SnackbarExamplePreview() {
    MaterialTheme {
        SnackbarExample()
    }
} 