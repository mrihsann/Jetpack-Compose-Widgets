package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var showBottomBar by remember { mutableStateOf(true) }
    var showTopBar by remember { mutableStateOf(true) }
    var showFAB by remember { mutableStateOf(true) }
    var showDrawer by remember { mutableStateOf(false) }

    if (showDrawer) {
        ModalDrawerSheet{
            Text(
                "Drawer Content",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge
            )
            HorizontalDivider()
            ListItem(
                headlineContent = { Text("Item 1") },
                leadingContent = { Icon(Icons.Default.Home, contentDescription = null) }
            )
            ListItem(
                headlineContent = { Text("Item 2") },
                leadingContent = { Icon(Icons.Default.Settings, contentDescription = null) }
            )
        }
    }

    Scaffold(
        topBar = {
            if (showTopBar) {
                TopAppBar(
                    title = { Text("Scaffold Example") },
                    navigationIcon = {
                        IconButton(onClick = { showDrawer = true }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { showTopBar = !showTopBar }) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        selected = true,
                        onClick = { }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                        label = { Text("Search") },
                        selected = false,
                        onClick = { }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                        label = { Text("Profile") },
                        selected = false,
                        onClick = { }
                    )
                }
            }
        },
        floatingActionButton = {
            if (showFAB) {
                FloatingActionButton(
                    onClick = { showFAB = !showFAB }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
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

            // Toggle Buttons
            Button(
                onClick = { showTopBar = !showTopBar },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (showTopBar) "Hide Top Bar" else "Show Top Bar")
            }

            Button(
                onClick = { showBottomBar = !showBottomBar },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (showBottomBar) "Hide Bottom Bar" else "Show Bottom Bar")
            }

            Button(
                onClick = { showFAB = !showFAB },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (showFAB) "Hide FAB" else "Show FAB")
            }

            Button(
                onClick = { showDrawer = !showDrawer },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (showDrawer) "Close Drawer" else "Open Drawer")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldExamplePreview() {
    MaterialTheme {
        ScaffoldExample()
    }
} 