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
fun BottomSheetExample() {
    var showBasicSheet by remember { mutableStateOf(false) }
    var showModalSheet by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Button to show basic bottom sheet
        Button(
            onClick = { showBasicSheet = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Basic Bottom Sheet")
        }

        // Button to show modal bottom sheet
        Button(
            onClick = { showModalSheet = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Show Modal Bottom Sheet")
        }
    }

    // Basic Bottom Sheet
    if (showBasicSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBasicSheet = false },
            sheetState = rememberModalBottomSheetState()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Basic Bottom Sheet",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "This is a basic bottom sheet example.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Button(
                    onClick = { showBasicSheet = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Close")
                }
            }
        }
    }

    // Modal Bottom Sheet
    if (showModalSheet) {
        ModalBottomSheet(
            onDismissRequest = { showModalSheet = false },
            sheetState = rememberModalBottomSheetState(),
            dragHandle = { BottomSheetDefaults.DragHandle() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Modal Bottom Sheet",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "This is a modal bottom sheet with a drag handle.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { showModalSheet = false },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Cancel")
                    }
                    Button(
                        onClick = { showModalSheet = false },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetExamplePreview() {
    MaterialTheme {
        BottomSheetExample()
    }
} 