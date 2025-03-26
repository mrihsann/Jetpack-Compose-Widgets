package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IconExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic Icon
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home Icon"
        )

        // Colored Icon
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite Icon",
            tint = Color.Red
        )

        // Large Icon
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Star Icon",
            modifier = Modifier.size(48.dp)
        )

        // Icon with Background
        Surface(
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email Icon",
                modifier = Modifier.padding(8.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        // Icon Button
        IconButton(
            onClick = { /* Handle click */ }
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        }

        // Row of Icons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person Icon"
            )
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings Icon"
            )
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications Icon"
            )
        }

        // Icon with Text
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info Icon",
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Icon with Text",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IconExamplePreview() {
    MaterialTheme {
        IconExample()
    }
} 