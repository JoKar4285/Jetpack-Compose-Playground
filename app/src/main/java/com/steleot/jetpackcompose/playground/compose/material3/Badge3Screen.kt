package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/Badge3Screen.kt"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Badge3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.Badge3,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Badge { Text("8", fontSize = 20.sp) }
            Badge(
                containerColor = Color.Magenta
            ) {
                Text("8", fontSize = 22.sp)
            }
            Badge(
                contentColor = Color.Red
            ) {
                Text("8", fontSize = 24.sp)
            }
        }
    }
}