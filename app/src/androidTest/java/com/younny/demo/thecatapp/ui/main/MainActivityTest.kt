package com.younny.demo.thecatapp.ui.main

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.younny.demo.thecatapp.TestMainActivity
import com.younny.demo.thecatapp.ui.main.TheCatApp
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@HiltAndroidTest
class MainActivityTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var composeTestRule = createAndroidComposeRule<TestMainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
        composeTestRule.setContent {
            TheCatApp()
        }
    }

    @After
    fun teardown() {
    }

    @Test
    fun main_launches_cats_image_screen() {
        composeTestRule.onNodeWithText("The Cat App").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Cat Images Screen").assertIsDisplayed()

    }
}