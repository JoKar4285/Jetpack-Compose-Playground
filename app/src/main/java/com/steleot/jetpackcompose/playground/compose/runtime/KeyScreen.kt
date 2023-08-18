package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "runtime/KeyScreen.kt"

@Composable
fun KeyScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.Key,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            LocallyUniqueKeysExample()
            Divider()
            NotAlwaysUniqueKeysExample()
            Divider()
            MoreCorrectUniqueKeysExample()
            Divider()
        }
    }
}

private val users = listOf(
    User(1, "Jetpack"),
    User(1, "Compose"),
    User(2, "Playground"),
    User(3, "Playground"),
    User(4, "Jetpack"),
)

@Composable
private fun LocallyUniqueKeysExample() {
    for (user in users) {
        key(user.id) { UserPreview(user = user) }
    }
}

@Composable
private fun UserPreview(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = stringResource(id = R.string.id_args, user.id), modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = R.string.name_args, user.name),
            modifier = Modifier.weight(1f)
        )
    }
}

private val relationships = mapOf(
    User(1, "Jetpack") to User(2, "Playground"),
    User(2, "Jetpack") to User(2, "Playground 2"),
    User(1, "Jetpack 2") to User(2, "Playground 3"),
    User(3, "Jetpack 3") to User(2, "Playground 4"),
)

@Composable
private fun NotAlwaysUniqueKeysExample() {
    for ((child, parent) in relationships) {
        key(parent.id) {
            UserPreview(child)
            UserPreview(parent)
        }
    }
}

@Composable
fun MoreCorrectUniqueKeysExample() {
    for ((child, parent) in relationships) {
        key(parent.id to child.id) {
            UserPreview(child)
            UserPreview(parent)
        }
    }
}