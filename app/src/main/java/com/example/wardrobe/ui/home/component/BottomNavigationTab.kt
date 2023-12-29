package com.example.wardrobe.ui.home.component

import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.wardrobe.R
import com.example.wardrobe.custom.RotateIcon
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

/**
 * 作用：底部的tab
 *
 * @author chenkexi
 * @date :2023/12/29
 */

@Composable
fun BottomNavigationTab(
    modifier: Modifier = Modifier,
    homeScreenState: MutableState<BottomNavType>
) {
    var animate by remember { mutableStateOf(false) }
    NavigationBar(
        modifier = modifier,
    ) {
        NavigationBarItem(
            icon = {
                FaIcon(
                    faIcon = FaIcons.Home,
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
            },
            selected = homeScreenState.value == BottomNavType.HOME,
            onClick = {
                homeScreenState.value = BottomNavType.HOME
                animate = false
            },
            label = {
                Text(
                    text = stringResource(id = R.string.navigation_item_home),
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        )
        NavigationBarItem(
            icon = {
                FaIcon(
                    faIcon = FaIcons.Tools, tint = LocalContentColor
                        .current.copy(
                            alpha =
                            LocalContentAlpha.current
                        )
                )
            },
            selected = homeScreenState.value == BottomNavType.WIDGETS,
            onClick = {
                homeScreenState.value = BottomNavType.WIDGETS
                animate = false
            },
            label = {
                Text(
                    text = stringResource(id = R.string.navigation_item_home),
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        )
        NavigationBarItem(
            icon = {
                RotateIcon(
                    state = animate,
                    asset = Icons.Default.PlayArrow,
                    angle = 720f,
                    duration = 2000
                )
            },
            selected = homeScreenState.value == BottomNavType.ANIMATION,
            onClick = {
                homeScreenState.value = BottomNavType.ANIMATION
                animate = true
            },
            label = {
                Text(
                    text = stringResource(id = R.string.navigation_item_home),
                    style = TextStyle(fontSize = 12.sp)
                )
            }

        )
        NavigationBarItem(
            icon = {
                FaIcon(
                    faIcon = FaIcons.LaptopCode, tint = LocalContentColor.current.copy(
                        alpha =
                        LocalContentAlpha.current
                    )
                )
            },
            selected = homeScreenState.value == BottomNavType.DEMOUI,
            onClick = {
                homeScreenState.value = BottomNavType.DEMOUI
                animate = false
            },
            label = {
                Text(
                    text = stringResource(id = R.string.navigation_item_home),
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        )
        NavigationBarItem(
            icon = {
                FaIcon(
                    faIcon = FaIcons.LayerGroup, tint = LocalContentColor
                        .current.copy(
                            alpha =
                            LocalContentAlpha.current
                        )
                )
            },
            selected = homeScreenState.value == BottomNavType.TEMPLATE,
            onClick = {
                homeScreenState.value = BottomNavType.TEMPLATE
                animate = false
            },
            label = {
                Text(
                    text = stringResource(id = R.string.navigation_item_home),
                    style = TextStyle(fontSize = 12.sp)
                )
            }

        )
    }
}