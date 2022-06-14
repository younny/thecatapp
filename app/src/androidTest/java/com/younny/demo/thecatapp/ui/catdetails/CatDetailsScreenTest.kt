package com.younny.demo.thecatapp.ui.catdetails

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import com.younny.demo.thecatapp.data.BaseCatRepository
import com.younny.demo.thecatapp.data.common.CallErrors
import com.younny.demo.thecatapp.data.model.CatImageDetails
import com.younny.demo.thecatapp.ui.main.NavigationKeys
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class CatDetailsScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    @Inject
    lateinit var catRepository: BaseCatRepository

    private val catDetails = CatImageDetails(id = "0", url = "https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg", width = 400, height = 300)
    private val stateHandle = SavedStateHandle(mutableMapOf<String, Any>(NavigationKeys.Arg.CAT_IMAGE_ID to "1"))
    lateinit var viewModel: CatDetailsViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        viewModel = CatDetailsViewModel(stateHandle, catRepository)
    }

    @Test
    fun displays_loading_spinner() {
        viewModel.update(CatDetailsState.Loading)
        composeTestRule.setContent {
            CatDetailsScreen(
                viewModel = viewModel
            )
        }
        composeTestRule.onNodeWithContentDescription("Cat Details Screen").assertIsDisplayed()
        composeTestRule.onNodeWithTag("loadingSpinner").assertIsDisplayed()
    }

    @Test
    fun displays_cat_image() {
        viewModel.update(CatDetailsState.ResultCatDetails(catDetails))
        composeTestRule.setContent {
            CatDetailsScreen(
                viewModel = viewModel
            )
        }

        composeTestRule.onNodeWithContentDescription("Cat Details Screen").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Cat Image").assertIsDisplayed()
    }

    @Test
    fun displays_error() {
        viewModel.update(CatDetailsState.Exception(callErrors = CallErrors.ErrorException(Exception("Error 404"))))
        composeTestRule.setContent {
            CatDetailsScreen(
                viewModel = viewModel
            )
        }

        composeTestRule.onNodeWithContentDescription("Cat Details Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Error 404").assertIsDisplayed()
    }
}