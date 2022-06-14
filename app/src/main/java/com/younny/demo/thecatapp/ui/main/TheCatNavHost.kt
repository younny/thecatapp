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
import com.younny.demo.thecatapp.ui.common.BaseRoute
import com.younny.demo.thecatapp.ui.game.GameScreen
import com.younny.demo.thecatapp.ui.main.NavigationKeys.Arg.CAT_IMAGE_ID
import com.younny.demo.thecatapp.ui.settings.SettingsScreen
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun TheCatNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BaseRoute.CatImages.name
    ) {
        composable(route = BaseRoute.CatImages.name) {
            val viewModel: CatsViewModel = hiltViewModel()
            CatsScreen(
                viewModel = viewModel,
                effectFlow = viewModel.effects.receiveAsFlow(),
                onNavigationRequested = { imageId ->
                    navController.navigate("${BaseRoute.CatDetails.name}/$imageId")
                }
            )
        }
        composable(
            route = "${BaseRoute.CatDetails.name}/{$CAT_IMAGE_ID}",
            arguments = listOf(
                navArgument(CAT_IMAGE_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            val viewModel: CatDetailsViewModel = hiltViewModel()
            CatDetailsScreen(viewModel = viewModel)
        }
        composable(route = BaseRoute.Breeds.name) {
            val viewModel: BreedsViewModel = hiltViewModel()
            BreedsScreen(state = viewModel.state)
        }
        composable(route = BaseRoute.Game.name) {
            GameScreen()
        }
        composable(route = BaseRoute.Settings.name) {
            SettingsScreen()
        }
    }
}

object NavigationKeys {
    object Arg {
        const val CAT_IMAGE_ID = "catImageId"
    }
}