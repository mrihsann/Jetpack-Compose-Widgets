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
fun DrawerExample() {
    var showDrawer by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(0) }
    
    ModalNavigationDrawer(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    "Drawer Header",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
                Divider()
                
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Home") },
                    selected = selectedItem == 0,
                    onClick = { selectedItem = 0 }
                )
                
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text("Profile") },
                    selected = selectedItem == 1,
                    onClick = { selectedItem = 1 }
                )
                
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                    label = { Text("Settings") },
                    selected = selectedItem == 2,
                    onClick = { selectedItem = 2 }
                )
                
                Divider()
                
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = null) },
                    label = { Text("About") },
                    selected = selectedItem == 3,
                    onClick = { selectedItem = 3 }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Drawer Example") },
                    navigationIcon = {
                        IconButton(onClick = { showDrawer = true }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
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
                    text = "Main Content",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                Text(
                    text = "Selected Item: $selectedItem",
                    style = MaterialTheme.typography.bodyLarge
                )
                
                Button(
                    onClick = { showDrawer = !showDrawer },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(if (showDrawer) "Close Drawer" else "Open Drawer")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerExamplePreview() {
    MaterialTheme {
        DrawerExample()
    }
} 