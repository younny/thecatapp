package com.younny.demo.thecatapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.younny.demo.thecatapp.ui.common.BaseScreen
import com.younny.demo.thecatapp.ui.menu.DrawerMenu
import com.younny.demo.thecatapp.ui.menu.TopMenuBar
import com.younny.demo.thecatapp.ui.menu.navigationIcon
import com.younny.demo.thecatapp.ui.theme.TheCatAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopMenuBar(navigationIcon(navController) {
                toggleDrawer(scope, scaffoldState)
            })
        },
        drawerBackgroundColor = MaterialTheme.colors.secondary,
        drawerContent = {
            DrawerMenu(navController) {
                toggleDrawer(scope, scaffoldState)
            }
        }
    ) {
        TheCatNavHost(navController)
    }
}

fun toggleDrawer(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    scope.launch {
        if (scaffoldState.drawerState.isClosed)
            scaffoldState.drawerState.open()
        else
            scaffoldState.drawerState.close()
    }
}

