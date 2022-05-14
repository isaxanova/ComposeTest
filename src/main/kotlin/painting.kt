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
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.PointerEventType
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
    var offsetText by remember { mutableStateOf(Offset(0f, 0f)) }
    var line by remember { mutableStateOf(mutableListOf<Offset>()) }

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
            Canvas(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxSize()
                    .onMouseMove(PointerEventType.Move) {
                        offsetText = it
                        line.add(it)
                    }
            ) {
                widthCanvas = size.width

                drawRect(
                    color = colorRect,
                    topLeft = Offset(x = rectPosition, y = 150f),
                    size = Size(50f, 80f)
                )
                drawText(offsetText.toString(), x = offsetText.x, y = offsetText.y + 100f)
                drawSin()
                drawAxisPoints()
                drawAxis()

                drawPoints(
                    points = line,
                    color = Color.Green,
                    strokeWidth = 15f,
                    pointMode = PointMode.Polygon
                )
            }
        }
    }

}

private fun DrawScope.drawSin() {
    val points = mutableListOf<Offset>()


    for (i in 0..size.maxDimension.toInt() step 1) {
        val x = i.toFloat()
        val y = y2(x)
        points.add(Offset(x, y))
    }

    drawPoints(
        points = points,
        color = Color.Red,
        strokeWidth = 5f,
        pointMode = PointMode.Points
    )
}

private fun DrawScope.drawAxisPoints() {
    var axisPointsX = mutableListOf<Offset>()
    for (i in 0..size.width.toInt() step 50) {
        val x = i.toFloat()
        val y = size.height / 2
        axisPointsX.add(Offset(x, y))
    }
    drawPoints(
        points = axisPointsX,
        color = Color.Red,
        strokeWidth = 5f,
        pointMode = PointMode.Points
    )
    var axisPointsY = mutableListOf<Offset>()
    for (i in 0..size.width.toInt() step 50) {
        val x = size.width / 2
        val y = i.toFloat()
        axisPointsY.add(Offset(x, y))
    }
    drawPoints(
        points = axisPointsY,
        color = Color.Red,
        strokeWidth = 5f,
        pointMode = PointMode.Points
    )
}

private fun DrawScope.drawAxis() {
    drawLine(
        start = Offset(x = 0f, y = size.height / 2),
        end = Offset(x = size.width, y = size.height / 2),
        color = Color.Black
    )
    drawLine(
        start = Offset(x = size.width / 2, y = 0f),
        end = Offset(x = size.width / 2, y = size.height),
        color = Color.Black
    )
}

fun y(x: Float): Float = 5f + x
fun y2(x: Float): Float = sin(x / 100) * 100 + 100