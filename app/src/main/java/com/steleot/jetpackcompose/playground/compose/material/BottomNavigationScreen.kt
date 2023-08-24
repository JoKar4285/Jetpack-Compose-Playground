package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TableChart
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
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/BottomNavigationScreen.kt"

@Composable
fun BottomNavigationScreen() {
    val selectedBottomNavigationView = remember { mutableIntStateOf(0) }
    val selectedBottomNavigationItem = remember { mutableIntStateOf(0) }
    DefaultScaffold(
        title = MaterialNavRoutes.BottomNavigation,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    selectedBottomNavigationView.intValue =
                        if (selectedBottomNavigationView.intValue == 2) 0 else selectedBottomNavigationView.intValue + 1
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
                    selectedBottomNavigationItem.intValue =
                        if (selectedBottomNavigationItem.intValue == 4) 0 else selectedBottomNavigationItem.intValue + 1
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
            HelperView(selectedBottomNavigationView.intValue, selectedBottomNavigationItem.intValue)
        }
    }
}

@Preview
@Composable
private fun HelperView(
    selectedBottomNavigationView: Int = 0,
    selectedBottomNavigationItem: Int = 0,
) {
    val selectedItem = remember { mutableIntStateOf(0) }
    Column {
        when (selectedBottomNavigationView) {
            0 -> StandardBottomNavigation {
                HelperNavigationItems(selectedItem, selectedBottomNavigationItem)
            }
            1 -> BackgroundColorBottomNavigation {
                HelperNavigationItems(selectedItem, selectedBottomNavigationItem)
            }
            2 -> ElevationBottomNavigation {
                HelperNavigationItems(selectedItem, selectedBottomNavigationItem)
            }
        }
    }
}

@Preview
@Composable
private fun RowScope.HelperNavigationItems(
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
            0 -> DefaultBottomNavigationItem(item, selected, onClick)
            1 -> LabelBottomNavigationItem(item, selected, onClick)
            2 -> AlwaysShowLabelBottomNavigationItem(item, selected, onClick)
            3 -> SelectedColorBottomNavigationItem(item, selected, onClick)
            4 -> UnselectedColorBottomNavigationItem(item, selected, onClick)
        }
    }
}

@Preview
@Composable
private fun StandardBottomNavigation(
    content: @Composable RowScope.() -> Unit = {}
) {
    BottomNavigation {
        content()
    }
}

@Preview
@Composable
private fun BackgroundColorBottomNavigation(
    content: @Composable RowScope.() -> Unit = {}
) {
    BottomNavigation(
        backgroundColor = Color.Magenta
    ) {
        content()
    }
}

@Preview
@Composable
private fun ElevationBottomNavigation(
    content: @Composable RowScope.() -> Unit = {}
) {
    BottomNavigation(
        elevation = 12.dp
    ) {
        content()
    }
}

@Composable
private fun RowScope.DefaultBottomNavigationItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.LabelBottomNavigationItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        label = { Text(text = pair.first) },
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.AlwaysShowLabelBottomNavigationItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        label = { Text(text = pair.first) },
        alwaysShowLabel = false,
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.SelectedColorBottomNavigationItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        selectedContentColor = Color.Red,
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.UnselectedColorBottomNavigationItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        unselectedContentColor = Color.LightGray,
        selected = selected,
        onClick = onClick,
    )
}
