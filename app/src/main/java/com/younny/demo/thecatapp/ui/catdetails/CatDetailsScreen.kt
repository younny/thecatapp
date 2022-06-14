package com.younny.demo.thecatapp.ui.catdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.younny.demo.thecatapp.data.model.CatImageDetails
import com.younny.demo.thecatapp.ui.common.ErrorOccurred
import com.younny.demo.thecatapp.ui.common.LoadingSpinner
import timber.log.Timber

@Composable
fun CatDetailsScreen(
    viewModel: CatDetailsViewModel
) {
    val state by viewModel.state.collectAsState()

    Surface(modifier = Modifier.semantics {
        contentDescription = "Cat Details Screen"
    }, color = MaterialTheme.colors.background) {
        when (state) {
            is CatDetailsState.Loading -> LoadingSpinner()
            is CatDetailsState.ResultCatDetails -> CatDetailsCard((state as CatDetailsState.ResultCatDetails).data)
            is CatDetailsState.Exception -> ErrorOccurred(errors = (state as CatDetailsState.Exception).callErrors)
            else -> {}
        }
    }
}

@Composable
fun CatDetailsCard(catDetails: CatImageDetails) {
    val context = LocalContext.current
    val url = catDetails.url
    val width = catDetails.width
    val height = catDetails.height
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 2.dp
    ) {
        Column(Modifier.wrapContentSize(Alignment.Center)) {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(
                        remember(url) {
                            ImageRequest.Builder(context)
                                .data(url)
                                .diskCacheKey(url)
                                .memoryCacheKey(url)
                                .build()
                        }
                    ),
                    modifier = Modifier
                        .size(width.dp, height.dp)
                        .semantics {
                            contentDescription = "Cat Image"
                        },
                    contentDescription = "cat image"
                )
            }
        }
    }
}

@Preview
@Composable
fun CatDetailsCardPreview() {
    CatDetailsCard(catDetails = CatImageDetails(id = "0", width = 300, height = 500, url = ""))
}
