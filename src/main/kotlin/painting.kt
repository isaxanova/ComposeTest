import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

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


    Row {
        Column {
            Button(
                onClick = {}
            ) {
                Text("do smth")
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

                drawRect(
                    color = Color.Blue,
                    topLeft = Offset(x = rectPosition, y = 150f),
                    size = Size(50f, 80f)
                )
            }
        }
    }

}