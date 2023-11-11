package com.example.wardrobe.compose.ui.custom

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wardrobe.R
import com.example.wardrobe.compose.painter.LinePainter
import com.example.wardrobe.compose.ui.theme.Purple200
import com.example.wardrobe.compose.ui.theme.WardrobeTheme

/**
 * 作用：可以翻转的卡片
 *
 * @author chenkexi
 * @date :2023/11/9
 */


@SuppressLint("ResourceType")
@Composable
fun FlipCard() {
    var rotated by remember { mutableStateOf(false) }
    val cardType = painterResource(R.drawable.ic_launcher_background)
    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500), label = ""
    )
    val animateFront by animateFloatAsState(
        targetValue = if (!rotated) 1f else 0f,
        animationSpec = tween(500), label = ""
    )
    val animateBack by animateFloatAsState(
        targetValue = if (rotated) 1f else 0f,
        animationSpec = tween(500), label = ""
    )
    val cardMask = ImageBitmap.imageResource(id = R.drawable.book)
    val cardBackground = ImageBitmap.imageResource(id = R.drawable.card_back)
    val customPainter = remember {
        LinePainter(cardBackground, cardMask)
    }
    Card(
        modifier = Modifier
            .height(400.dp)
            .width(270.dp)
            .padding(10.dp)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
            }
            .clickable {
                rotated = !rotated
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        if (!rotated) {

            Box(Modifier.fillMaxSize()){
                Image(
                    painter = customPainter,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(14.dp)),
                    contentScale = ContentScale.FillBounds
                )

            }

            Box (Modifier.fillMaxSize().background(Color.Transparent)){

            }

//            Column(
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
//            ) {
//                Row(horizontalArrangement = Arrangement.SpaceBetween) {
//                    Icon(
//                        painter = painterResource(R.drawable.welcome_background),
//                        contentDescription = "test",
//                        modifier = Modifier
//                            .width(50.dp)
//                            .height(50.dp)
//                            .padding(top = 6.dp, bottom = 6.dp, end = 20.dp)
//                            .graphicsLayer {
//                                alpha = animateFront
//                            },
//                        tint = Color.White
//                    )
//                    Spacer(modifier = Modifier.weight(1f))
//                    Image(
//                        painter = cardType,
//                        contentDescription = "test",
//                        modifier = Modifier
//                            .width(50.dp)
//                            .height(50.dp)
//                            .graphicsLayer {
//                                alpha = animateFront
//                            }
//                    )
//                }
//                Text(
//                    text = "hhhhhh",
//                    modifier = Modifier
//                        .padding(top = 16.dp)
//                        .graphicsLayer {
//                            alpha = animateFront
//                        },
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 25.sp
//                )
//
//                Row(horizontalArrangement = Arrangement.SpaceBetween) {
//                    Column(horizontalAlignment = Alignment.Start) {
//                        Text(
//                            text = "Card Holder",
//                            color = Color.Gray,
//                            fontSize = 9.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .graphicsLayer {
//                                    alpha = animateFront
//                                }
//                        )
//                        Text(
//                            text = "Mehmet Yozgatli",
//                            color = Color.White,
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .graphicsLayer {
//                                    alpha = animateFront
//                                }
//                        )
//                    }
//                    Spacer(modifier = Modifier.weight(1f))
//                    Column(horizontalAlignment = Alignment.Start) {
//                        Text(
//                            text = "VALID THRU",
//                            color = Color.Gray,
//                            fontSize = 9.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .graphicsLayer {
//                                    alpha = animateFront
//                                }
//                        )
//
//                        Text(
//                            text = "ttttttt",
//                            color = Color.White,
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .graphicsLayer {
//                                    alpha = animateFront
//                                }
//                        )
//
//                    }
//                }
//            }
        } else {
            Column(
                modifier = Modifier.padding(top = 20.dp),
            ) {
                Divider(
                    modifier = Modifier
                        .graphicsLayer {
                            alpha = animateBack
                        }, color = Color.Black, thickness = 50.dp
                )
                Text(
                    text = "123",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Color.White)
                        .fillMaxWidth()
                        .graphicsLayer {
                            alpha = animateBack
                            rotationY = rotation
                        }
                        .padding(10.dp),
                    fontSize = 15.sp,
                    textAlign = TextAlign.End
                )
                Text(
                    text = "Developed by Mehmet Yozgatli",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            alpha = animateBack
                            rotationY = rotation
                        }
                        .padding(5.dp),
                    fontWeight = FontWeight.Thin,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun DefaulPreview() {
    WardrobeTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .background(Color.White, RoundedCornerShape(20.dp, 20.dp))
        ) {
            FlipCard()
        }
    }
}