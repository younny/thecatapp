package com.younny.demo.thecatapp.ui.menu

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.younny.demo.thecatapp.utils.previousBackStackEntryAsState
import kotlinx.coroutines.Job

@Composable
fun navigationIcon(navController: NavController, onToggleDrawer: () -> Unit): @Composable (() -> Unit) {
//    val previousBackStackEntry: NavBackStackEntry? by navController.previousBackStackEntryAsState()
//    if (previousBackStackEntry != null) {
//        return {
//            IconButton(onClick = {
//                navController.popBackStack()
//            }) {
//                Icon(Icons.Default.ArrowBack, contentDescription = "Back Button")
//            }
//        }
//    }
    return {
        IconButton(onClick = {
            onToggleDrawer()
        }, modifier = Modifier.semantics {
            contentDescription = "Menu Button"
        }) {
            Icon(Icons.Default.Menu, contentDescription = "Menu Icon")
        }
    }
}