package com.ihsanarslan.jetpackcomposewidgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderExample() {
    var sliderValue by remember { mutableStateOf(0f) }
    var rangeSliderValue by remember { mutableStateOf(0f..100f) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic Slider
        Text("Basic Slider: ${sliderValue.toInt()}")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            modifier = Modifier.fillMaxWidth()
        )

        // Slider with Steps
        Text("Slider with Steps: ${sliderValue.toInt()}")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f,
            steps = 5,
            modifier = Modifier.fillMaxWidth()
        )

        // Range Slider
        Text("Range Slider: ${rangeSliderValue.start.toInt()} - ${rangeSliderValue.endInclusive.toInt()}")
        RangeSlider(
            value = rangeSliderValue,
            onValueChange = { rangeSliderValue = it },
            valueRange = 0f..100f,
            modifier = Modifier.fillMaxWidth()
        )

        // Slider with Custom Colors
        Text("Colored Slider: ${sliderValue.toInt()}")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )

        // Disabled Slider
        Text("Disabled Slider: ${sliderValue.toInt()}")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SliderExamplePreview() {
    MaterialTheme {
        SliderExample()
    }
} 