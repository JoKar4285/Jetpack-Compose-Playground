package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TableChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val URL = "material3/NavigationBarScreen.kt"

@Composable
fun NavigationBarScreen() {
    val selectedNavigationBar = remember { mutableIntStateOf(0) }
    val selectedNavigationBarItem = remember { mutableIntStateOf(0) }
    DefaultScaffold(
        title = Material3NavRoutes.NavigationBar,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        selectedNavigationBar.intValue =
                            if (selectedNavigationBar.intValue == 2) 0 else selectedNavigationBar.intValue + 1
                    }
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.switch_args,
                            stringResource(id = R.string.bottom_navigation)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        selectedNavigationBarItem.intValue =
                            if (selectedNavigationBarItem.intValue == 4) 0 else selectedNavigationBarItem.intValue + 1
                    }
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.switch_args,
                            stringResource(id = R.string.bottom_navigation_item)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                HelperView(
                    selectedNavigationBar.intValue,
                    selectedNavigationBarItem.intValue
                )
            }
        }
    }
}

@Composable
private fun HelperView(
    selectedNavigationBar: Int = 0,
    selectedNavigationBarItem: Int = 0,
) {
    val selectedItem = remember { mutableIntStateOf(0) }
    Column {
        when (selectedNavigationBar) {
            0 -> StandardNavigationBar {
                HelperNavigationBarItems(selectedItem, selectedNavigationBarItem)
            }
            1 -> ContainerColorNavigationBar {
                HelperNavigationBarItems(selectedItem, selectedNavigationBarItem)
            }
            2 -> TonalElevationNavigationBar {
                HelperNavigationBarItems(selectedItem, selectedNavigationBarItem)
            }
        }
    }
}

@Composable
private fun RowScope.HelperNavigationBarItems(
    selectedItem: MutableState<Int> = mutableIntStateOf(0),
    selectedNavigationItem: Int = 0,
    items: List<Pair<String, ImageVector>> = listOf(
        Pair(stringResource(id = R.string.person), Icons.Filled.Person),
        Pair(stringResource(id = R.string.table_chart), Icons.Filled.TableChart),
        Pair(stringResource(id = R.string.settings), Icons.Filled.Settings)
    ),
) {
    items.forEachIndexed { index, item ->
        val selected = selectedItem.value == index
        val onClick = { selectedItem.value = index }
        when (selectedNavigationItem) {
            0 -> DefaultNavigationBarItem(item, selected, onClick)
            1 -> LabelNavigationBarItem(item, selected, onClick)
            2 -> AlwaysShowLabelNavigationBarItem(item, selected, onClick)
            3 -> SelectedIconColorNavigationBarItem(item, selected, onClick)
            4 -> UnselectedIconColorNavigationBarItem(item, selected, onClick)
        }
    }
}

@Composable
private fun StandardNavigationBar(
    content: @Composable RowScope.() -> Unit = {}
) {
    NavigationBar {
        content()
    }
}

@Composable
private fun ContainerColorNavigationBar(
    content: @Composable RowScope.() -> Unit = {}
) {
    NavigationBar(
        containerColor = Color.Magenta
    ) {
        content()
    }
}

@Preview
@Composable
private fun TonalElevationNavigationBar(
    content: @Composable RowScope.() -> Unit = {}
) {
    NavigationBar(
        tonalElevation = 12.dp
    ) {
        content()
    }
}

@Composable
private fun RowScope.DefaultNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.LabelNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        label = { Text(text = pair.first) },
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.AlwaysShowLabelNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        label = { Text(text = pair.first) },
        alwaysShowLabel = false,
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.SelectedIconColorNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Red
        ),
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.UnselectedIconColorNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.LightGray
        ),
        selected = selected,
        onClick = onClick,
    )
}

