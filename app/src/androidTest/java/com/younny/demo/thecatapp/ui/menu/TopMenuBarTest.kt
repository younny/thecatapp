package com.younny.demo.thecatapp.ui.menu

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.junit.Rule
import org.junit.Test

class TopMenuBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: NavHostController

    @Test
    fun toggle_drawer() {
        var drawerToggled = false
        composeTestRule.setContent {
            navController = rememberNavController()
            TopMenuBar(
                navigationIcon = navigationIcon(navController = navController) {
                    drawerToggled = true
                }
            )
        }

        composeTestRule.onNodeWithText("The Cat App").assertIsDisplayed()

        val backStack = navController.previousBackStackEntry
        assert(backStack == null)
        composeTestRule.onNodeWithContentDescription("Menu Button").assertIsDisplayed().apply {
            performClick()
        }
        assert(drawerToggled)
    }
}