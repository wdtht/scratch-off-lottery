package com.example.wardrobe.ui.home.component

import android.content.res.Configuration
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.wardrobe.R


/**
 * 作用：主页面
 *
 * @author chenkexi
 * @date :2023/11/8
 */


@Composable
fun MainScreen() {
    val homeScreenState = rememberSaveable { mutableStateOf(BottomNavType.HOME) }
    val bottomNavBarContentDescription = stringResource(id = R.string.a11y_bottom_navigation_bar)

    val config = LocalConfiguration.current
    val orientation = config.orientation
    //判断是横屏还是竖屏
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        //竖屏
        Column(modifier = Modifier.fillMaxSize()) {
            HomeScreenContent(
                homeScreen = homeScreenState.value,
                modifier = Modifier.weight(1f)
            )
            BottomNavigationTab(
                modifier = Modifier
                    .semantics { contentDescription = bottomNavBarContentDescription },
                homeScreenState = homeScreenState
            )
        }
    } else {
        //横屏
        Row(modifier = Modifier.fillMaxSize()) {
            NavigationRailTab(
                modifier = Modifier
                    .semantics { contentDescription = bottomNavBarContentDescription },
                homeScreenState = homeScreenState
            )
            HomeScreenContent(
                homeScreen = homeScreenState.value,
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Composable
fun HomeScreenContent(
    homeScreen: BottomNavType,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Crossfade(homeScreen, label = "") { screen ->
            Surface(color = MaterialTheme.colorScheme.background) {
                when (screen) {
                    BottomNavType.HOME -> HomeScreen()
                    BottomNavType.WIDGETS -> HomeScreenB()
                    BottomNavType.ANIMATION -> HomeScreen()
                    BottomNavType.DEMOUI -> HomeScreen()
                    BottomNavType.TEMPLATE -> HomeScreen()

                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Color.Gray)) {
        Text(text = "aaaaaaaaaa")
    }

}

@Composable
fun HomeScreenB() {
    Column() {
        Text(text = "bbbbbbbbbb")
    }

}

