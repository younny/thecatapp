package com.younny.demo.thecatapp.ui.menu

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class TopMenuBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun set_different_icon() {
        composeTestRule.setContent {
            TopMenuBar(
                navigationIcon = {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Icon")
                }
            )
        }

        composeTestRule.onNodeWithText("The Cat App").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Menu Icon").assertIsDisplayed()
    }
}