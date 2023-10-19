package com.example.jetpackcomposecomponentes

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment


@Composable
fun MyBasicSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun MyAdvanceSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    var completeValue by remember {
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completeValue = sliderPosition.toString() },
            valueRange = 0f..100f,
            steps = 99
        )
        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    var currenRange by remember {
        mutableStateOf(0f..0f)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        RangeSlider(
            value = currenRange,
            onValueChange = { currenRange = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = "Valor inferior ${currenRange.start}")
        Text(text = "Valor superior ${currenRange.endInclusive}")
    }


}