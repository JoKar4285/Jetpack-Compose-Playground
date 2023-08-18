package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/SpacerScreen.kt"

@Composable
fun SpacerScreen() {
    val msgSplit = stringResource(id = R.string.spacer_msg).split(' ')
    val toIndex = if (msgSplit.size % 2 == 0) msgSplit.size / 2 else (msgSplit.size + 1) / 2
    val columnList = msgSplit.subList(0, toIndex)
    val rowList = msgSplit.subList(toIndex, msgSplit.size)

    DefaultScaffold(
        title = FoundationNavRoutes.Spacer,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            columnList.forEachIndexed { index, text ->
                Text(text = text)
                if (index < columnList.size) {
                    Spacer(modifier = Modifier.requiredHeight(16.dp))
                }
                Spacer(modifier = Modifier.requiredHeight(16.dp))
            }
            Row {
                rowList.forEachIndexed { index, text ->
                    Text(text = text)
                    if (index < rowList.size) {
                        Spacer(modifier = Modifier.requiredWidth(16.dp))
                    }
                }
            }
        }
    }
}