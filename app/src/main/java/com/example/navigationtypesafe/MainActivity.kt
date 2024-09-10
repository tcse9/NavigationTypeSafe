package com.example.navigationtypesafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.example.navigationtypesafe.ui.components.HomeScreen
import com.example.navigationtypesafe.ui.components.MediaDetailsScreen
import com.example.navigationtypesafe.ui.components.MovieScreen
import com.example.navigationtypesafe.ui.route.Details
import com.example.navigationtypesafe.ui.route.Home
import com.example.navigationtypesafe.ui.route.Movies
import com.example.navigationtypesafe.ui.theme.Media
import com.example.navigationtypesafe.ui.theme.NavigationTypeSafeTheme
import com.example.navigationtypesafe.utils.Constant
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTypeSafeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = Home::class
                    ) {
                        composable<Home> {
                            HomeScreen(navController, "Home Page", onButtonClick = {
                                navController.navigate(
                                    Movies(screenName = "Movies")
                                )
                            })
                        }
                        composable<Movies>(deepLinks = listOf(navDeepLink<Movies>(basePath = "${Constant.BASE_URL_DEEPLINK}/movies"))) {
                            MovieScreen(navHostController = navController)
                        }

                        composable<Details>(deepLinks = listOf(navDeepLink<Details>(basePath = "${Constant.BASE_URL_DEEPLINK}/details"))) {
                            MediaDetailsScreen(navHostController = navController, id = it.toRoute<Details>().mediaId)
                        }
                    }
                }
            }
        }
    }
}