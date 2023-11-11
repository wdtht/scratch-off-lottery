package com.example.wardrobe.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.wardrobe.R
import com.example.wardrobe.compose.ui.custom.ViewButton
import com.example.wardrobe.compose.ui.theme.Grey200

@Composable
fun WelcomeBody(clickable: Clickable = combinedClickable()) {
    Surface(color = Color.Transparent) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(20.dp, 20.dp))
        ) {
            ConstraintLayout(Modifier.weight(1.8f)) {
                val (imageBackground, backgroundPic, imageBackgroundTitle, imageBackgroundTips, contentText, bookIcon) = createRefs()
                Image(
                    painter = painterResource(R.drawable.welcome_background),
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(imageBackground) {
                            top.linkTo(parent.top)
                        }
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                        .padding(top = 0.dp),
                    contentScale = ContentScale.FillWidth
                )
                Image(
                    painter = painterResource(R.drawable.book), contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .constrainAs(backgroundPic) {
                            top.linkTo(parent.top, 150.dp)
                            centerHorizontallyTo(parent)
                        },
                    contentScale = ContentScale.FillWidth
                )
                Text(
                    text = "What To Eat Today!",
                    modifier = Modifier.constrainAs(imageBackgroundTitle) {
                        centerHorizontallyTo(parent)
                        top.linkTo(backgroundPic.top, 60.dp)
                    },
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                    ),
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    text = "Customize recipes and plan your diet！",
                    modifier = Modifier.constrainAs(imageBackgroundTips) {
                        centerHorizontallyTo(parent)
                        top.linkTo(imageBackgroundTitle.top, 30.dp)
                    },
                    maxLines = 2,
                    style = TextStyle(
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                    ),
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    text = "Enjoy your own \nrecipe",
                    style = TextStyle(
                        color = Grey200,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                    ),
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    modifier = Modifier.constrainAs(contentText) {
                        start.linkTo(parent.start, 50.dp)
                        top.linkTo(imageBackground.bottom, 30.dp)
                    },
                    fontFamily = FontFamily.SansSerif
                )
                Image(
                    painter = painterResource(R.drawable.book_icon), contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .constrainAs(bookIcon) {
                            start.linkTo(contentText.end, 90.dp)
                            bottom.linkTo(contentText.bottom, 30.dp)
                        },
                    contentScale = ContentScale.FillWidth
                )
            }
            Box(Modifier.weight(0.6f), contentAlignment = Alignment.Center) {
                ViewButton(
                    onClick = { clickable.onStart() },
                    width = 300.dp,
                    height = 50.dp,
                    content = "Get Started",
                )
            }
        }
    }

}

data class Clickable constructor(
    val onStart: () -> Unit
)

fun combinedClickable(
    onStart: () -> Unit = {}
) = Clickable(onStart)
