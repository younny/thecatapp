package com.younny.demo.thecatapp.ui.menu

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.junit.Rule
import org.junit.Test

class DrawerMenuTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: NavHostController

    @Test
    fun check_drawer_contents() {
        composeTestRule.setContent {
            navController = rememberNavController()
            DrawerMenu(navController, ::toggleDrawer)
        }

        composeTestRule.onNodeWithText("Cats").assertIsDisplayed()
        composeTestRule.onNodeWithText("Breeds").assertIsDisplayed()
        composeTestRule.onNodeWithText("Game").assertIsDisplayed()
        composeTestRule.onNodeWithText("Settings").assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Cats Menu Icon").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Breeds Menu Icon").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Game Menu Icon").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Settings Menu Icon").assertIsDisplayed()

    }
}