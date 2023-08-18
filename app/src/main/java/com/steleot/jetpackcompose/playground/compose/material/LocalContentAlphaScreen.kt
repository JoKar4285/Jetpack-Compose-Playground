package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ContentAlpha
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.LocalContentAlpha
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/LocalContentAlphaScreen.kt"

@Composable
fun LocalContentAlphaScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.LocalContentAlpha,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(id = R.string.no_content_alpha, LocalContentAlpha.current))
            CompositionLocalProvider(LocalContentAlpha provides 1.00f) {
                Text(
                    stringResource(
                        id = R.string.content_alpha,
                        stringResource(id = R.string.maximum),
                        LocalContentAlpha.current
                    )
                )
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                Text(
                    stringResource(
                        id = R.string.content_alpha,
                        stringResource(id = R.string.high_content),
                        LocalContentAlpha.current
                    )
                )
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    stringResource(
                        id = R.string.content_alpha,
                        stringResource(id = R.string.medium_content),
                        LocalContentAlpha.current
                    )
                )
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                Text(
                    stringResource(
                        id = R.string.content_alpha,
                        stringResource(id = R.string.disabled_content),
                        LocalContentAlpha.current
                    )
                )
            }
        }
    }
}