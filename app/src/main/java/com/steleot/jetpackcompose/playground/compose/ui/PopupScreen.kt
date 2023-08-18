package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/PopupScreen.kt"

@Composable
fun PopupScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Popup,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                val popupWidth = 200.dp
                val popupHeight = 50.dp
                val cornerSize = 16.dp

                Popup(alignment = Alignment.Center) {
                    Box(
                        Modifier
                            .size(popupWidth, popupHeight)
                            .background(Color.Magenta, RoundedCornerShape(cornerSize))
                    )
                }
            }
        }
    }
}