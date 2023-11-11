package com.example.wardrobe.compose.ui.custom

import android.view.MotionEvent.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wardrobe.compose.ui.theme.WardrobeTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ViewButton(
    modifier: Modifier = Modifier,
    width: Dp,
    height: Dp,
    onClick: () -> Unit = {},
    autoInvokeWhenPressed: Boolean = false,
    content: String
) {
    val interactionSource = MutableInteractionSource()

    Box(modifier = Modifier.shadow(10.dp, shape = RoundedCornerShape(8.dp))
        .indication(interactionSource = interactionSource, indication = rememberRipple()).run {
            if (autoInvokeWhenPressed) {
                pointerInteropFilter {
                    when (it.action) {
                        ACTION_DOWN -> {

                        }

                        ACTION_CANCEL, ACTION_UP -> {

                        }

                        else -> {
                            return@pointerInteropFilter false
                        }
                    }
                    true
                }
            } else {
                clickable { onClick() }
            }
        }
    ) {

        Text(text = content, style = TextStyle(
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
        ), fontWeight = FontWeight.Bold, maxLines = 1, modifier = Modifier
            .drawWithCache {
                val brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF9E82F0), Color(0xFF42A5F5)
                    )
                )
                onDrawBehind {
                    drawRoundRect(
                        brush, cornerRadius = CornerRadius(8.dp.toPx())
                    )
                }
            }
            .width(width)
            .height(height)
            .padding(10.dp))
    }
}

@Preview
@Composable
fun DefaultPreview() {
    WardrobeTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .background(Color.White, RoundedCornerShape(20.dp, 20.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.55f)
            ) {
                ViewButton(
                    Modifier.align(Alignment.TopCenter),
                    width = 500.dp,
                    height = 50.dp,
                    content = "Hello World"
                )
            }
        }
    }
}
