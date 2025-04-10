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
fun TopAppBarExample() {
    var showTopAppBar by remember { mutableStateOf(true) }
    
    Scaffold(
        topBar = {
            if (showTopAppBar) {
                TopAppBar(
                    title = { Text("TopAppBar Example") },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle navigation */ }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Handle action */ }) {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        }
                        IconButton(onClick = { /* Handle action */ }) {
                            Icon(Icons.Default.MoreVert, contentDescription = "More")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
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
            
            // Toggle TopAppBar Button
            Button(
                onClick = { showTopAppBar = !showTopAppBar },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (showTopAppBar) "Hide TopAppBar" else "Show TopAppBar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarExamplePreview() {
    MaterialTheme {
        TopAppBarExample()
    }
} 