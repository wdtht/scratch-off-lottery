package com.example.wardrobe.compose.ui

import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ShareCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wardrobe.compose.MainScreen
import com.example.wardrobe.compose.WelcomeBody
import com.example.wardrobe.compose.combinedClickable

/**
 * 作用：跳转
 *
 * @author chenkexi
 * @date :2023/11/8
 */

@Composable
fun RecipesApp() {
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
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeBody(combinedClickable(
                onStart = {
                    //点击开始
                    navController.navigate("main/mainView")
                }
            ))
        }
        composable("main/mainView") {
            MainScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}

// Helper function for calling a share functionality.
// Should be used when user presses a share button/menu item.
//private fun createShareIntent(activity: Activity, plantName: String) {
//    val shareText = activity.getString(R.string.share_text_plant, plantName)
//    val shareIntent = ShareCompat.IntentBuilder(activity)
//        .setText(shareText)
//        .setType("text/plain")
//        .createChooserIntent()
//        .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
//    activity.startActivity(shareIntent)
//}