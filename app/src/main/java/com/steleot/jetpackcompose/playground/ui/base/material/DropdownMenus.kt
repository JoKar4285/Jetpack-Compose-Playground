package com.steleot.jetpackcompose.playground.ui.base.material

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.DropdownMenu
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.DropdownMenuItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.compose.rest.ShouldReload
import com.steleot.jetpackcompose.playground.localproviders.LocalFavoriteHelper
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.localproviders.LocalUser
import com.steleot.jetpackcompose.playground.utils.setResult
import com.steleot.jetpackcompose.playground.utils.shortToast
import kotlinx.coroutines.launch

@Composable
fun DefaultDropdownMenu(
    route: String,
    iconButton: @Composable (() -> Unit) -> Unit
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val user = LocalUser.current
    val favoriteHelper = LocalFavoriteHelper.current
    val navController = LocalNavController.current
    var expanded by remember { mutableStateOf(false) }
    var isFavorite by remember { mutableStateOf(false) }

    user?.let {
        LaunchedEffect(Unit) {
            isFavorite = favoriteHelper.isFavorite(user.uid, route)
        }
        iconButton {
            expanded = true
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = {
                expanded = false
                scope.launch {
                    val tempFavorite = favoriteHelper.addRemoveFavorite(user.uid, route)
                    val resId = if (tempFavorite == isFavorite) {
                        R.string.failed_favorites
                    } else {
                        navController.setResult(ShouldReload, true)
                        isFavorite = tempFavorite
                        if (tempFavorite) R.string.added_favorites else R.string.removed_favorites
                    }
                    context.shortToast(resId)
                }
            }) {
                Text(stringResource(id = if (isFavorite) R.string.unfavorite else R.string.favorite))
            }
        }
    }
}