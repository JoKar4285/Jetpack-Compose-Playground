package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/AlignmentLineScreen.kt"

@Composable
fun AlignmentLineScreen() {
    DefaultScaffold(
        title = UiNavRoutes.AlignmentLine,
        link = URL,
    ) {
        val exampleLine = remember { FirstBaseline }

        @Composable
        fun LineProviderLayout(exampleLinePosition: Int) {
            val size = 50
            Layout({}, modifier = Modifier.background(Color.Blue)) { _, _ ->
                layout(size, size, mapOf(exampleLine to exampleLinePosition)) {}
            }
        }

        Layout({
            LineProviderLayout(exampleLinePosition = 5)
            LineProviderLayout(exampleLinePosition = 10)
        }, modifier = Modifier.padding(paddingValues = it).background(Color.Red)) { measurables, constraints ->
            val placeables = measurables.map { measurable -> measurable.measure(constraints) }
            layout(constraints.maxWidth, constraints.maxHeight) {
                placeables[0].place(0, 50)
                placeables[1].place(constraints.maxWidth / 2, 0)
            }
        }
    }
}