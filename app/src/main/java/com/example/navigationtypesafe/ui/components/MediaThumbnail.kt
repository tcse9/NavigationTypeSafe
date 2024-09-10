package com.example.navigationtypesafe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigationtypesafe.R
import com.example.navigationtypesafe.ui.theme.Media

@Composable
fun MediaThumbnail(media: Media, onMediaClick: (Media) -> Unit) {
    Card(
        modifier = Modifier.clickable { onMediaClick(media) },
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(all = 4.dp),
                text = media.title
            )
        }

    }
}

@Composable
@Preview
fun Prev_MediaThumbnail(onMediaClick: (Media) -> Unit = {}) {
    val media = Media(id = 1, title = "Movie 1")
    MediaThumbnail(media = media, onMediaClick = onMediaClick)
}

