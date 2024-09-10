package com.example.navigationtypesafe.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationtypesafe.ui.route.Details
import com.example.navigationtypesafe.ui.route.Movies
import com.example.navigationtypesafe.ui.theme.Media
import com.example.navigationtypesafe.utils.Constant.mediaList

@Composable
fun MovieScreen(navHostController: NavHostController) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        columns = GridCells.Adaptive(100.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),

    ) {
        itemsIndexed(mediaList) { index, item ->
            MediaThumbnail(
                media = item,
                onMediaClick = { navHostController.navigate(Details(item.id)) })
        }
    }
}

@Composable
@Preview
fun Prev_MovieScreen() {
    val mediaList = listOf(
        Media(id = 1, title = "title 1"),
        Media(id = 2, title = "title 2"),
        Media(id = 3, title = "title 3"),
        Media(id = 4, title = "title 4")
    )
    MovieScreen(navHostController = rememberNavController())
}