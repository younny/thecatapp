package com.younny.demo.thecatapp.ui.cats

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.ui.common.LoadingSpinner
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@Composable
fun CatsScreen(
    viewModel: CatsViewModel,
    effectFlow: Flow<CatsContract.Effect>?,
    onNavigationRequested: (imageId: String) -> Unit
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(effectFlow) {
        effectFlow?.onEach { effect ->
            if (effect is CatsContract.Effect.Loaded) {
                //todo cats are loaded.
                Timber.v("<--- cat images are loaded")
            }
        }?.collect()
    }

    Box(
        modifier = Modifier.semantics {
            contentDescription = "Cat Images Screen"
        }
    ) {

        when (state) {
            is CatsState.Loading -> LoadingSpinner()
            is CatsState.ResultAllCatImages -> {
                CatsList(catImages = (state as CatsState.ResultAllCatImages).data) { imageId ->
                    onNavigationRequested(imageId)
                }
            }
            else -> {}
        }
    }
}

@Composable
fun CatsList(catImages: List<CatImage>, onItemClicked: (id: String) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(catImages) { cat ->
            CatItemRow(
                item = cat,
                onItemClicked = onItemClicked
            )
        }
    }
}

@Composable
fun CatItemRow(item: CatImage, onItemClicked: (id: String) -> Unit) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .clickable { onItemClicked(item.id) }
    ) {
        Row(modifier = Modifier.animateContentSize()) {
            Box(modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
                CatThumbnail(context, item)
            }
            CatDetails(item = item)
        }
    }
}

@Composable
fun CatDetails(item: CatImage) {
    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 24.dp)
            .fillMaxWidth(0.80f)
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Text(
            text = item.url,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        item.breeds.map {
            Text(
                text = it.name
            )
        }
    }
}

@Composable
fun CatThumbnail(context: Context, item: CatImage) {
    Image(
        painter = rememberAsyncImagePainter(
            remember(item.url) {
                ImageRequest.Builder(context)
                    .data(item.url)
                    .diskCacheKey(item.url)
                    .memoryCacheKey(item.url)
                    .build()
            }
        ),
        modifier = Modifier
            .size(88.dp)
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
        contentDescription = "cat thumbnail"
    )
}
