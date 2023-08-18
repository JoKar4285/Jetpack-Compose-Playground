package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/LocalFocusManagerScreen.kt"

@Composable
fun LocalFocusManagerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalFocusManager,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalFocusManagerExample()
        }
    }
}

@Composable
private fun LocalFocusManagerExample() {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val (value1, setValue1) = remember { mutableStateOf(context.getString(R.string.value_args, 1)) }
    val (value2, setValue2) = remember { mutableStateOf(context.getString(R.string.value_args, 2)) }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = value1,
            onValueChange = setValue1
        )
        TextField(
            value = value2,
            onValueChange = setValue2
        )
        Button(onClick = {
            focusManager.clearFocus()
        }) {
            Text(text = context.getString(R.string.tap_clear_focus))
        }
    }
}