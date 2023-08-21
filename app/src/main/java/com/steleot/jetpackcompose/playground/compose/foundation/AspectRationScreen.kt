package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/AspectRationScreen.kt"

@Composable
fun AspectRationScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.AspectRatio,
        link = URL,
    ) {
        Column(
            modifier = Modifier.padding(paddingValues = it)
        ) {
            Box(
                modifier = Modifier
                    .requiredHeight(50.dp)
                    .aspectRatio(0.25f)
                    .background(Color.Green)
            )
            Box(
                modifier = Modifier
                    .requiredHeight(100.dp)
                    .aspectRatio(0.55f)
                    .background(Color.Magenta)
            )
            Box(
                modifier = Modifier
                    .requiredHeight(200.dp)
                    .aspectRatio(0.75f)
                    .background(Color.Red)
            )
        }
    }
}
