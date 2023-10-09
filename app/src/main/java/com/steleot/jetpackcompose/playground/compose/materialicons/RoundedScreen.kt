package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "materialicons/RoundedScreen.kt"

@Composable
fun RoundedScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Rounded,
        link = URL,
    ) {
        RoundedGrid(paddingValues = it)
    }
}

private val list = listOf(
    Icons.Rounded.AccountBox,
    Icons.Rounded.AccountCircle,
    Icons.Rounded.AddCircle,
    Icons.Rounded.Add,
    Icons.AutoMirrored.Rounded.ArrowBack,
    Icons.Rounded.ArrowDropDown,
    Icons.AutoMirrored.Rounded.ArrowForward,
    Icons.Rounded.Build,
    Icons.Rounded.Call,
    Icons.Rounded.CheckCircle,
    Icons.Rounded.Check,
    Icons.Rounded.Clear,
    Icons.Rounded.Close,
    Icons.Rounded.Create,
    Icons.Rounded.DateRange,
    Icons.Rounded.Delete,
    Icons.Rounded.Done,
    Icons.Rounded.Edit,
    Icons.Rounded.Email,
    Icons.AutoMirrored.Rounded.ExitToApp,
    Icons.Rounded.Face,
    Icons.Rounded.FavoriteBorder,
    Icons.Rounded.Favorite,
    Icons.Rounded.Home,
    Icons.Rounded.Info,
    Icons.Rounded.KeyboardArrowDown,
    Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
    Icons.AutoMirrored.Rounded.KeyboardArrowRight,
    Icons.Rounded.KeyboardArrowUp,
    Icons.AutoMirrored.Rounded.List,
    Icons.Rounded.LocationOn,
    Icons.Rounded.Lock,
    Icons.Rounded.MailOutline,
    Icons.Rounded.Menu,
    Icons.Rounded.MoreVert,
    Icons.Rounded.Notifications,
    Icons.Rounded.Person,
    Icons.Rounded.Phone,
    Icons.Rounded.Place,
    Icons.Rounded.PlayArrow,
    Icons.Rounded.Refresh,
    Icons.Rounded.Search,
    Icons.AutoMirrored.Rounded.Send,
    Icons.Rounded.Settings,
    Icons.Rounded.Share,
    Icons.Rounded.ShoppingCart,
    Icons.Rounded.Star,
    Icons.Rounded.ThumbUp,
    Icons.Rounded.Warning,
)

@Preview
@Composable
private fun RoundedGrid(paddingValues: PaddingValues = PaddingValues()) {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp),
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = null, modifier = Modifier.padding(8.dp))
        }
    }
}
