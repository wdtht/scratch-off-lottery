package com.example.wardrobe.ui.home.component

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * 作用：跳转
 *
 * @author chenkexi
 * @date :2023/11/8
 */

@Composable
fun MainApp() {
    val navController = rememberNavController()
    RecipesNavHost(
        navController = navController
    )
}
@Composable
fun RecipesNavHost(
    navController: NavHostController
) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = "main/mainView") {
        composable("main/mainView") {
            MainScreen()
        }
    }
}
