package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListExample() {
    val items = List(20) { "Item ${it + 1}" }
    val horizontalItems = List(10) { "H ${it + 1}" }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic List
        Text(
            text = "Basic List",
            style = MaterialTheme.typography.titleMedium
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

        // Horizontal List
        Text(
            text = "Horizontal List",
            style = MaterialTheme.typography.titleMedium
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(horizontalItems) { item ->
                Card(
                    modifier = Modifier.width(100.dp)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

        // List with Dividers
        Text(
            text = "List with Dividers",
            style = MaterialTheme.typography.titleMedium
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(items.size) { index ->
                if (index > 0) {
                    HorizontalDivider()
                }
                ListItem(
                    headlineContent = { Text(items[index]) },
                    supportingContent = { Text("Supporting text for ${items[index]}") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    }
                )
            }
        }

        // List with Selection
        var selectedItem by remember { mutableStateOf<String?>(null) }
        Text(
            text = "Selectable List",
            style = MaterialTheme.typography.titleMedium
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(items) { item ->
                ListItem(
                    headlineContent = { Text(item) },
                    leadingContent = {
                        RadioButton(
                            selected = selectedItem == item,
                            onClick = { selectedItem = item }
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListExamplePreview() {
    MaterialTheme {
        ListExample()
    }
} 