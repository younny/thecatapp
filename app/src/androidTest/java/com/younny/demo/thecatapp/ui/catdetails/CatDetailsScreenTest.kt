package com.younny.demo.thecatapp.ui.catdetails

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.younny.demo.thecatapp.data.model.CatImageDetails
import org.junit.Rule
import org.junit.Test

class CatDetailsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val catDetails = CatImageDetails(id = "0", url = "https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg", width = 400, height = 300)


    @Test
    fun displays_loading_spinner() {
        composeTestRule.setContent {
            CatDetailsScreen(
                BreedsContract.State(
                    details = null,
                    isLoading = true
                )
            )
        }
        composeTestRule.onNodeWithContentDescription("Cat Details Screen").assertIsDisplayed()
        composeTestRule.onNodeWithTag("loadingSpinner").assertIsDisplayed()
    }

    @Test
    fun displays_cat_image() {
        composeTestRule.setContent {
            CatDetailsScreen(
                BreedsContract.State(
                    details = catDetails,
                    isLoading = false
                )
            )
        }

        composeTestRule.onNodeWithContentDescription("Cat Details Screen").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Cat Image").assertIsDisplayed()
    }

    @Test
    fun displays_error() {
        composeTestRule.setContent {
            CatDetailsScreen(
                BreedsContract.State(
                    details = null,
                    isLoading = false,
                    error = "Error 404"
                )
            )
        }

        composeTestRule.onNodeWithContentDescription("Cat Details Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Error 404").assertIsDisplayed()
    }
}