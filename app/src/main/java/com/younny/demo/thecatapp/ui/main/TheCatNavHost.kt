package com.younny.demo.thecatapp.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.younny.demo.thecatapp.ui.breeds.BreedsScreen
import com.younny.demo.thecatapp.ui.breeds.BreedsViewModel
import com.younny.demo.thecatapp.ui.catdetails.CatDetailsScreen
import com.younny.demo.thecatapp.ui.catdetails.CatDetailsViewModel
import com.younny.demo.thecatapp.ui.cats.CatsScreen
import com.younny.demo.thecatapp.ui.cats.CatsViewModel
import com.younny.demo.thecatapp.ui.common.BaseScreen
import com.younny.demo.thecatapp.ui.main.NavigationKeys.Arg.CAT_IMAGE_ID
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun TheCatNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BaseScreen.CatImages.name
    ) {
        composable(route = BaseScreen.CatImages.name) {
            val viewModel: CatsViewModel = hiltViewModel()
            CatsScreen(
                state = viewModel.state,
                effectFlow = viewModel.effects.receiveAsFlow(),
                onNavigationRequested = { imageId ->
                    navController.navigate("${BaseScreen.CatDetails.name}/$imageId")
                }
            )
        }
        composable(
            route = "${BaseScreen.CatDetails.name}/{$CAT_IMAGE_ID}",
            arguments = listOf(
                navArgument(CAT_IMAGE_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            val viewModel: CatDetailsViewModel = hiltViewModel()
            CatDetailsScreen(state = viewModel.state)
        }
        composable(route = BaseScreen.Breeds.name) {
            val viewModel: BreedsViewModel = hiltViewModel()
            BreedsScreen(state = viewModel.state)
        }
    }
}

object NavigationKeys {
    object Arg {
        const val CAT_IMAGE_ID = "catImageId"
    }
}