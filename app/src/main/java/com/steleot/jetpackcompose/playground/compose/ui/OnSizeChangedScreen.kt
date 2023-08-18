package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val URL = "ui/OnSizeChangedScreen.kt"

@Composable
fun OnSizeChangedScreen() {
    DefaultScaffold(
        title = UiNavRoutes.OnSizeChanged,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OnSizeChangedExample(name = stringResource(id = R.string.app_name))
            OnSizeChangedExample(name = stringResource(id = R.string.example))
        }
    }
}

@Composable
private fun OnSizeChangedExample(
    name: String
) {
    Text(
        stringResource(id = R.string.hello_with_args, name),
        Modifier.onSizeChanged { size ->
            Timber.d("The size of the Text in pixels is $size")
        }
    )
}