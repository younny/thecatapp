package com.younny.demo.thecatapp.ui.menu

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.younny.demo.thecatapp.ui.main.toggleDrawer
import org.junit.Rule
import org.junit.Test

class DrawerMenuTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: NavHostController

    @Test
    fun check_drawer_contents() {
        composeTestRule.setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            navController = rememberNavController()
            DrawerMenu(navController) {
                toggleDrawer(scope, scaffoldState)
            }
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