package com.example.wardrobe.compose

import android.graphics.Path
import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.wardrobe.R
import com.example.wardrobe.compose.ui.custom.LuckyCard

/**
 * 作用：
 *
 * @author chenkexi
 * @date :2023/11/8
 */
data class MainClickCallbacks(
    val onFabClick: () -> Unit,
    val onBackClick: () -> Unit,
    val onShareClick: (String) -> Unit
)

@Composable
fun MainScreen(
//    plantDetailsViewModel: MainScreenViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    Surface {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (luckyCard) = createRefs()
            LuckyCard(
                modifier = Modifier
                    .constrainAs(luckyCard) {
                        centerTo(parent)
                    }
            )
        }
    }

}

@Composable
fun PrizeGrid(prizes: List<String>, modifier: Modifier = Modifier) {
    GridLayout(prizes = prizes, modifier = modifier)
}

@Composable
fun GridLayout(prizes: List<String>, modifier: Modifier) {
    // 使用 Column 和 Row 创建网格布局
    Column(modifier = modifier) {
        for (i in prizes.indices step 5) {
            Row {
                for (j in 0 until 5) {
                    if (i + j < prizes.size) {
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                            contentAlignment = Alignment.Center) {
                            Text(text = prizes[i + j] ,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ScratchCard(prizes: List<String>) {
    Box(modifier = Modifier.fillMaxSize()) {
        PrizeGrid(prizes = prizes)
//        ScratchOffCanvas {
//            // 这里可以添加额外的逻辑，比如记录刮开的位置等
//        }
    }
}
@Composable
fun MyApp() {
    val prizes = listOf("100元", "50元", "20元", "10元", "5元") // 示例奖金
    ScratchCard(prizes = prizes)
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScratchOffCanvas(modifier: Modifier = Modifier, onScratch: (Offset) -> Unit) {
    val path = Path()
    val paint = Paint().apply {
        color = Color.Red
        style = PaintingStyle.Fill
    }

    Canvas(modifier = modifier
        .fillMaxSize()
        .pointerInteropFilter { event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN,
                MotionEvent.ACTION_MOVE -> {
                    path.addCircle(
                        event.x,
                        event.y,
                        30f, // 擦除半径
                        Path.Direction.CCW
                    )
                    onScratch(Offset(event.x, event.y))
                    true
                }

                else -> false
            }
        }) {
        drawRect(
            color = Color.Blue,
            size = this.size
        )
        drawContext.canvas.nativeCanvas.drawPath(path, paint.asFrameworkPaint())
    }
}


