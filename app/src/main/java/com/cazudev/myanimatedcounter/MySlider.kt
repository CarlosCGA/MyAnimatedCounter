package com.cazudev.myanimatedcounter

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MySlider() {
    var progress by rememberSaveable {
        mutableFloatStateOf(0F)
    }

    Slider(
        value = progress,
        onValueChange = { newProgress ->
            Log.d("CARLOS", "NEW VALUE -> $newProgress")
            progress = newProgress
        },
        onValueChangeFinished = {
        },
        valueRange = -3f..3f,
        colors = SliderDefaults.colors(
            activeTrackColor = colorResource(id = R.color.deep_purple_400),
            inactiveTrackColor = colorResource(id = R.color.deep_purple_400),
            inactiveTickColor = colorResource(id = R.color.orangeTextColor),
            activeTickColor = colorResource(id = R.color.orangeTextColor)
        ),
        thumb = {
            Image(
                painter = painterResource(id = R.drawable.weight_icon_orange),
                contentDescription = "icon"
            )
        }
    )
}