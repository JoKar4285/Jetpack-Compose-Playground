package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/BrushScreen.kt"

@Composable
fun BrushScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Brush,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val linear = Brush.linearGradient(listOf(Color.Red, Color.Blue))

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(linear)
            )

            Spacer(modifier = Modifier.size(20.dp))

            val radial = Brush.radialGradient(listOf(Color.Green, Color.Magenta))
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(radial)
            )

            Spacer(modifier = Modifier.size(20.dp))

            val sweep = Brush.sweepGradient(listOf(Color.Cyan, Color.Magenta))
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(sweep)
            )
        }
    }
}