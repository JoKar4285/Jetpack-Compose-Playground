package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Punched

private const val URL = "externallibraries/ComposeNeumorphismScreen.kt"

@Composable
fun ComposeNeumorphismScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeNeumorphism,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NeumorphicExample()
        }
    }
}

@Composable
private fun NeumorphicExample() {
    Button(
        onClick = { },
        modifier = Modifier
            .padding(12.dp)
            .neumorphic(
                neuShape = Punched.Rounded(radius = 8.dp)
            )
    ) {
        Text(text = stringResource(id = R.string.press_me))
    }
}
