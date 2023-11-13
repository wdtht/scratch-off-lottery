package com.example.wardrobe.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.wardrobe.R
import com.example.wardrobe.compose.ui.theme.Grey200

@Composable
fun WelcomeBody() {
    Surface(color = Color.White) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (imageBackground, imageBackgroundTitle, imageBackgroundTips) = createRefs()
            Image(
                painter = painterResource(R.drawable.welcome_icon),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(imageBackground) {
                        centerTo(parent)
                    }
                    .size(120.dp)
                    .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp)),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier.constrainAs(imageBackgroundTitle) {
                    centerHorizontallyTo(parent)
                    top.linkTo(imageBackground.bottom, 20.dp)
                },
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    color = Grey200,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                ),
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "@design by kx & xf",
                modifier = Modifier.constrainAs(imageBackgroundTips) {
                    centerHorizontallyTo(parent)
                    bottom.linkTo(parent.bottom, 40.dp)
                },
                maxLines = 1,
                style = TextStyle(
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                ),
                fontFamily = FontFamily.SansSerif
            )
        }

    }

}

//data class Clickable constructor(
//    val onStart: () -> Unit
//)
//
//fun combinedClickable(
//    onStart: () -> Unit = {}
//) = Clickable(onStart)
