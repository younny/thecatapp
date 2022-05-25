package com.younny.demo.thecatapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.younny.demo.thecatapp.ui.common.BaseScreen
import com.younny.demo.thecatapp.ui.menu.TopMenuBar
import com.younny.demo.thecatapp.ui.menu.navigationIcon
import com.younny.demo.thecatapp.ui.theme.TheCatAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheCatAppTheme {
                TheCatApp()
            }
        }
    }
}

@Composable
fun TheCatApp() {
    val allScreens = BaseScreen.values().toList()
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentScreen = BaseScreen.fromRoute(backStackEntry.value?.destination?.route)

    Scaffold(
        topBar = {
            TopMenuBar(navigationIcon(navController))
        }
    ) {
        TheCatNavHost(navController)
    }
}

