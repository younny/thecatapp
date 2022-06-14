package com.younny.demo.thecatapp.ui.cats

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.hilt.navigation.compose.hiltViewModel
import com.younny.demo.thecatapp.data.BaseCatRepository
import com.younny.demo.thecatapp.data.CatRepository
import com.younny.demo.thecatapp.data.model.CatImage
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class CatsScreenTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    private val catImages: List<CatImage> = listOf(CatImage("0", "https://abc", breeds = listOf(), categories = listOf()))

    @Inject
    lateinit var catsRepository: BaseCatRepository

    lateinit var viewModel: CatsViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        viewModel = CatsViewModel(catsRepository)

    }

    @After
    fun teardown() {
    }

    @Test
    fun show_loading_spinner() {
        viewModel.update(CatsState.Loading)

        composeTestRule.setContent {
            CatsScreen(
                viewModel = viewModel,
                effectFlow = null,
                onNavigationRequested = {}
            )
        }

        composeTestRule.onNodeWithContentDescription("Cat Images Screen").assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("loadingSpinner"))
    }

    @Test
    fun loads_cat_images_list() {
        viewModel.update(CatsState.ResultAllCatImages(catImages))

        composeTestRule.setContent {
            CatsScreen(
                viewModel = viewModel,
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
        viewModel.update(CatsState.ResultAllCatImages(catImages))
        composeTestRule.setContent {
            CatsScreen(
                viewModel = viewModel,
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