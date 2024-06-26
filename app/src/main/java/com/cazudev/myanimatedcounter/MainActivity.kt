package com.cazudev.myanimatedcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.cazudev.myanimatedcounter.ui.theme.MyAnimatedCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAnimatedCounterTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    var count by remember {
                        mutableIntStateOf(0)
                    }
                    AnimatedCounter(count = count, style = MaterialTheme.typography.headlineMedium)

                    Row {
                        FilledIconButton(onClick = { count-- }) {
                            Icon(
                                modifier = Modifier.rotate(-90F),
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "decrement counter"
                            )
                        }
                        Spacer(modifier = Modifier.size(4.dp))
                        FilledIconButton(onClick = { count++ }) {
                            Icon(
                                modifier = Modifier.rotate(-90F),
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "increment counter"
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.size(16.dp))
                    
                    MySmoothTickSlider()

                    Spacer(modifier = Modifier.size(16.dp))

                    MySlider()
                }
            }
        }
    }
}