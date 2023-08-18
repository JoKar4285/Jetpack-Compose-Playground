package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter
import kotlin.collections.plus
import kotlin.collections.sorted
import com.steleot.jetpackcompose.playground.compose.activity.routes as activityRoutes
import com.steleot.jetpackcompose.playground.compose.animation.routes as animationRoutes
import com.steleot.jetpackcompose.playground.compose.constraintlayout.routes as constraintLayoutRoutes
import com.steleot.jetpackcompose.playground.compose.customexamples.routes as customExamplesRoutes
import com.steleot.jetpackcompose.playground.compose.externallibraries.routes as externalRoutes

private const val URL = "customexamples/AnimatedDeleteListScreen.kt"

@Composable
fun AnimatedDeleteListScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.AnimatedDeleteList,
        link = URL,
    ) {
        AnimatedDeleteListExample(routesList)
    }
}

internal val routesList
    get(): List<String> = (activityRoutes +
            animationRoutes +
            constraintLayoutRoutes +
            customExamplesRoutes +
            externalRoutes).sorted()

@Composable
private fun AnimatedDeleteListExample(routes: List<String>) {
    val deletedRouteList = remember { mutableStateListOf<String>() }
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        itemsIndexed(routes) { index, route ->
            AnimatedVisibility(
                visible = !deletedRouteList.contains(route),
                enter = expandVertically(),
                exit = shrinkVertically(
                    animationSpec = tween(
                        durationMillis = 1000,
                    )
                )
            ) {
                CardExample(index, route, Modifier.fillParentMaxWidth()) {
                    IconButton(
                        onClick = {
                            deletedRouteList.add(route)
                        }
                    ) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = stringResource(id = R.string.delete_route),
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CardExample(
    index: Int,
    route: String,
    modifier: Modifier = Modifier,
    trailing: @Composable (() -> Unit)? = null,
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .padding(vertical = 8.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        ListItem(
            icon = {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color(colors[index % colors.size]))
                ) {
                    Text(
                        text = route.first().uppercaseChar().toString(),
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.onSurface,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            trailing = trailing
        ) {
            Text(
                text = route.capitalizeFirstLetter(),
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}
