package com.younny.demo.thecatapp.ui.game

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            GameScreen()
        }
    }

    @After
    fun teardown() {

    }

    @Test
    fun render_grid_view() {
        composeTestRule.onNodeWithContentDescription("Cat Image Grid").assertIsDisplayed()
    }
}