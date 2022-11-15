package com.ilfey.wc.ui.components.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ilfey.wc.utils.AppConstants.BASEURL

@Composable
fun RowMovieList(
    /*TODO add List*/
) {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
//        FIXME items count from List
        items(50) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
                    .clickable {
//                        TODO start FilmActivity
                    },
//                FIXME url from List item
                painter = rememberAsyncImagePainter("${BASEURL}img/100x150.png"),
                contentDescription = "",
            )
        }
    }
}