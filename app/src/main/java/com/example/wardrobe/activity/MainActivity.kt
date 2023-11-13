package com.example.wardrobe.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.wardrobe.compose.ui.MainApp
import com.example.wardrobe.compose.ui.theme.WardrobeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //可以做一些初始的东西

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WardrobeTheme {
                MainApp()
            }
        }

    }
}
