package com.cazudev.myanimatedcounter

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MySlider() {
    var progress by rememberSaveable {
        mutableFloatStateOf(0F)
    }
    var progressTransition by rememberSaveable {
        mutableFloatStateOf(progress)
    }

    LaunchedEffect(key1 = progressTransition) {
        while (progressTransition != progress) {
            if (progressTransition > progress)
                progress += 0.01F
            else if (progressTransition < progress)
                progress -= 0.01F

            delay(1)
        }
    }

    Slider(
        value = progress,
        onValueChange = { newProgress ->
            Log.d("CARLOS", "NEW VALUE -> $newProgress")
            progressTransition = newProgress
        },
        onValueChangeFinished = {
        },
        steps = 5,
        valueRange = -3f..3f,
        colors = SliderDefaults.colors(
            activeTrackColor = Color.Magenta,
            inactiveTrackColor = Color.Magenta,
            inactiveTickColor = Color.Yellow,
            activeTickColor = Color.Yellow
        ),
        thumb = { Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "icon") }
    )
}