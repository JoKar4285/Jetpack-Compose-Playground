package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import hu.ma.charts.legend.data.LegendPosition
import hu.ma.charts.pie.PieChart
import hu.ma.charts.pie.data.PieChartData
import hu.ma.charts.pie.data.PieChartEntry

private const val URL = "externallibraries/ComposeChartsScreen.kt"

@Composable
fun ComposeChartsScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeCharts,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PieChartExample()
        }
    }
}

private val categories = listOf(
    R.string.teams,
    R.string.locations,
    R.string.devices,
    R.string.people,
    R.string.laptops,
    R.string.titles,
)

private val simpleColors = listOf(
    Color.Black,
    Color.Blue,
    Color.Yellow,
    Color.Red,
    Color.LightGray,
    Color.Magenta,
)

@Composable
private fun PieChartExample() {
    val data = PieChartData(
        entries = listOf(430f, 240f, 140f, 60f, 50f).mapIndexed { idx, value ->
            PieChartEntry(
                value = value,
                label = AnnotatedString(
                    stringResource(id = categories[idx])
                )
            )
        },
        colors = simpleColors,
        legendPosition = LegendPosition.End,
        legendShape = CircleShape,
    )
    PieChart(data = data, chartSize = 150.dp, modifier = Modifier.padding(32.dp))
}
