package com.example.jetpackcomposewidgets.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarExample() {
    var selectedItem by remember { mutableStateOf(0) }
    var showBottomBar by remember { mutableStateOf(true) }
    
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        selected = selectedItem == 0,
                        onClick = { selectedItem = 0 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                        label = { Text("Search") },
                        selected = selectedItem == 1,
                        onClick = { selectedItem = 1 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                        label = { Text("Profile") },
                        selected = selectedItem == 2,
                        onClick = { selectedItem = 2 }
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Content
            Text(
                text = "Main Content",
                style = MaterialTheme.typography.headlineMedium
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Selected Item Text
            Text(
                text = "Selected Item: $selectedItem",
                style = MaterialTheme.typography.bodyLarge
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Toggle BottomBar Button
            Button(
                onClick = { showBottomBar = !showBottomBar },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (showBottomBar) "Hide BottomBar" else "Show BottomBar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarExamplePreview() {
    MaterialTheme {
        BottomBarExample()
    }
} 