import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.math.sin

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        paint()
    }
}

@Composable
@Preview
fun paint() {
    var rectPosition by remember { mutableStateOf(0f) }
    var widthCanvas by remember { mutableStateOf(0f) }
    var colorRect by remember { mutableStateOf(Color.Blue) }

    Row {
        Column {
            Button(
                onClick = {
                    if (colorRect == Color.Blue) {
                        colorRect = Color.Red
                    } else colorRect = Color.Blue
                }
            ) {
                Text("change color")
            }

        }
        Column {
            Slider(
                value = rectPosition,
                onValueChange = { rectPosition = it },
                valueRange = 0f..widthCanvas
            )
            Canvas(modifier = Modifier.background(Color.Gray).fillMaxSize()) {
                widthCanvas = size.width
                val points = mutableListOf<Offset>()

                for (i in 0..size.maxDimension.toInt() step 1) {
                    val x = i.toFloat()
                    val y = y2(x = i.toFloat())

                    val point = Offset(x, y)
                    points.add(point)
                }

                drawRect(
                    color = colorRect,
                    topLeft = Offset(x = rectPosition, y = 150f),
                    size = Size(50f, 80f)
                )
                drawCircle(
                    color = Color.Blue,
                    center = Offset(x = size.width / 2, y = size.height / 2),
                    radius = size.minDimension / 4
                )
                drawLine(
                    start = Offset(x = size.width, y = 0f),
                    end = Offset(x = 0f, y = size.height),
                    color = Color.Blue
                )
                drawPoints(
                    points = points,
                    color = Color.Red,
                    strokeWidth = 5f,
                    pointMode = PointMode.Points
                )
            }
        }
    }

}

fun y(x: Float): Float = 5f + x
fun y2(x: Float): Float = sin(x / 10) * 10 + 100