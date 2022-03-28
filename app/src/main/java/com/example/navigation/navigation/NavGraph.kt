package com.example.navigation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navigation.screens.DetailScreen
import com.example.navigation.screens.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARG_ID) {
                    type = NavType.IntType
                    defaultValue = 0
                },
//                navArgument(DETAIL_ARG_NAME) {
//                    type = NavType.StringType
//                }
            )
        ) {
            Log.d("Args", it.arguments?.getInt(DETAIL_ARG_ID).toString())
            DetailScreen(navController)
        }

    }
}