package com.example.wardrobe.ui.welcome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.wardrobe.ui.home.MainActivity
import com.example.wardrobe.ui.welcome.component.WelcomeBody
import com.example.wardrobe.theme.WardrobeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 作用：欢迎页
 *
 * @author chenkexi
 * @date :2023/11/13
 */
class WelcomeActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //可以做一些初始的东西

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WardrobeTheme {
                WelcomeBody()
                lifecycleScope.launch(Dispatchers.IO) {
                    delay(2000)
                    withContext(Dispatchers.Main) {
                        //跳转
                        val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
                        this@WelcomeActivity.startActivity(intent)
                        this@WelcomeActivity.finish()
                    }
                }
            }
        }

    }
}