package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/AnimateItemPlacementScreen.kt"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnimateItemPlacementScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.AnimateItemPlacement,
        link = URL,
    ) {
        var list by remember { mutableStateOf((0..20).toList()) }
        LazyColumn(
            contentPadding = it
        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { list = list.shuffled() },
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Text(stringResource(id = R.string.shuffle))
                    }
                }
            }
            items(list, key = { item -> item }) { item ->
                Text(
                    stringResource(id = R.string.item, item),
                    modifier = Modifier
                        .animateItemPlacement()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                        .border(1.dp, MaterialTheme.colors.primary, RoundedCornerShape(2.dp))
                        .padding(8.dp)
                        .fillMaxWidth()

                )
            }
        }
    }
}