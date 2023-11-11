package com.example.wardrobe

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.wardrobe.compose.WelcomeBody
import com.example.wardrobe.compose.combinedClickable
import com.example.wardrobe.compose.ui.RecipesApp
import com.example.wardrobe.compose.ui.theme.WardrobeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //可以做一些初始的东西

        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            setContent {
                WardrobeTheme {
                    RecipesApp()
                }
            }
        }
    }
}
