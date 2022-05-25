package com.younny.demo.thecatapp.ui.cats

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.younny.demo.thecatapp.data.model.CatImage
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CatsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val catImages: List<CatImage> = listOf(CatImage("0", "https://abc", breeds = listOf(), categories = listOf()))

    @Before
    fun setup() {
    }

    @After
    fun teardown() {

    }

    @Test
    fun show_loading_spinner() {
        composeTestRule.setContent {
            CatsScreen(
                state = CatsContract.State(
                    catImages = listOf(),
                    isLoading = true
                ),
                effectFlow = null,
                onNavigationRequested = {}
            )
        }

        composeTestRule.onNodeWithContentDescription("Cat Images Screen").assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("loadingSpinner"))
    }

    @Test
    fun loads_cat_images_list() {
        composeTestRule.setContent {
            CatsScreen(
                state = CatsContract.State(
                    catImages = catImages,
                    isLoading = false
                ),
                effectFlow = null,
                onNavigationRequested = {}
            )
        }

        composeTestRule.onNodeWithContentDescription("Cat Images Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText(catImages[0].url).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("cat thumbnail").assertIsDisplayed()
    }

    @Test
    fun click_cat_item() {
        var itemClicked = false
        composeTestRule.setContent {
            CatsScreen(
                state = CatsContract.State(
                    catImages = catImages,
                    isLoading = false
                ),
                effectFlow = null,
                onNavigationRequested = {
                    itemClicked = true
                }
            )
        }

        composeTestRule.onNodeWithContentDescription("Cat Images Screen").assertIsDisplayed()
        composeTestRule.onNodeWithTag("loadingSpinner").assertDoesNotExist()
        composeTestRule.onNodeWithText(catImages[0].url).performClick()

        assert(itemClicked)
    }
}