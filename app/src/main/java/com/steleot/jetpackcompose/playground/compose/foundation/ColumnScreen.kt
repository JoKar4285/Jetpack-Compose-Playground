package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/ColumnScreen.kt"

@Composable
fun ColumnScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Column,
        link = URL,
    ) {
        DefaultColumn(paddingValues = it)
    }
}

@Composable
fun DefaultColumn(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues = paddingValues)
    ) {
        Text(
            text = stringResource(id = R.string.item_args, 1),
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Blue)
        )
        Text(
            text = stringResource(id = R.string.item_args, 2),
            modifier = Modifier
                .background(Color.Red)
                .padding(16.dp)
        )
        Text(
            text = stringResource(id = R.string.item_args, 3),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(Color.Green)
        )
        Text(
            text = stringResource(id = R.string.item_args, 4),
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth(0.6f)
                .padding(16.dp)
        )
    }
}
