package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.progressSemantics
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/ProgressSemanticsScreen.kt"

@Composable
fun ProgressSemanticsScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.ProgressSemantics,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProgressSemanticsExample()
        }
    }
}

@Composable
private fun ProgressSemanticsExample() {
    var enabled by remember { mutableStateOf(false) }
    val progress by animateFloatAsState(
        targetValue = if (!enabled) 0f else 100f,
        animationSpec = tween(1_500),
        label = "ProgressSemanticsExample",
    )
    LaunchedEffect(Unit) {
        enabled = true
    }
    Box(
        Modifier
            .progressSemantics(progress)
            .size((progress * 2.5).dp, 8.dp)
            .background(color = MaterialTheme.colors.primary)
    )
}