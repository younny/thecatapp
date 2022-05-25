package com.younny.demo.thecatapp.ui.main

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.younny.demo.thecatapp.TestMainActivity
import com.younny.demo.thecatapp.ui.common.BaseScreen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class TheCatNavHostTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<TestMainActivity>()

    lateinit var navController: NavHostController

    @Before
    fun setup() {
        hiltRule.inject()
        composeTestRule.setContent {
            navController = rememberNavController()
            TheCatNavHost(navController = navController)
        }
    }

    @Test
    fun launches_cat_images_screen() {
        composeTestRule.onNodeWithContentDescription("Cat Images Screen").assertIsDisplayed()

        val route = navController.currentBackStackEntry?.destination?.route
        assert(route == BaseScreen.CatImages.name)
    }

//    @Test
//    fun navigate_to_cat_details_screen() {
//        val newRoute = "${BaseScreen.CatDetails.name}/0"
//        runBlocking {
//            withContext(Dispatchers.Main) {
//                navController.navigate(newRoute)
//            }
//        }
//        val route = navController.currentBackStackEntry?.destination?.route
//        assert(route == newRoute)
//        composeTestRule.onNodeWithContentDescription("Cat Details Screen").assertIsDisplayed()
//    }
}