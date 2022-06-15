package com.younny.demo.thecatapp.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.younny.demo.thecatapp.R
import com.younny.demo.thecatapp.ui.common.BaseRoute

@Composable
fun DrawerMenu(
    navController: NavHostController,
    onToggleDrawer: () -> Unit
) {
    val items = listOf(
        DrawerMenuItem.Cats,
        DrawerMenuItem.Breeds,
        DrawerMenuItem.Game,
        DrawerMenuItem.Settings
    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentScreen = BaseRoute.fromRoute(backStackEntry.value?.destination?.route)

    LazyColumn(modifier = Modifier.semantics { contentDescription = "Drawer Menu" }) {
        item {
            DrawerHeader()
        }
        items(items.size) { index ->
            val menuItem = items[index]
            DrawerContent(item = menuItem, selected = currentScreen.name == menuItem.route) {
                navController.navigate(menuItem.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                    onToggleDrawer()
                }
            }
        }
    }
}

@Composable
fun DrawerContent(
    item: DrawerMenuItem,
    selected: Boolean,
    onItemClick: (DrawerMenuItem) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(onClick = {
                onItemClick(item)
            })
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Icon(imageVector = item.icon, contentDescription = "${item.title} Menu Icon")

                Spacer(modifier = Modifier.width(16.dp))

        if (selected) {
            Text(
                text = item.title,
                modifier = Modifier.weight(1f),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 21.sp,
                    color = Color.Black
                )
            )
        } else {
            Text(
                text = item.title,
                modifier = Modifier.weight(1f),
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "The Cat Logo",
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    val navController = rememberNavController()
    DrawerMenu(navController) {}
}