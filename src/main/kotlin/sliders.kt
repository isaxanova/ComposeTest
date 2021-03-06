import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun slidersColor() {
    Column(Modifier.width(700.dp)) {
        var sliderColorsR by remember { mutableStateOf(0f) }
        var sliderColorsG by remember { mutableStateOf(0f) }
        var sliderColorsB by remember { mutableStateOf(0f) }
        Box(
            modifier = Modifier
                .width(700.dp)
                .height(200.dp)
                .background(color = Color(red = sliderColorsR, green = sliderColorsG, blue = sliderColorsB))
        )
        Text(text = "Текущее значение: $sliderColorsB", fontSize = 22.sp)
        Slider(
            value = sliderColorsB,
            onValueChange = { sliderColorsB = it },
            valueRange = 0f..1f
        )
        Text(text = "Текущее значение: $sliderColorsR", fontSize = 22.sp)
        Slider(
            value = sliderColorsR,
            onValueChange = { sliderColorsR = it },
            valueRange = 0f..1f
        )
        Text(text = "Текущее значение: $sliderColorsG", fontSize = 22.sp)
        Slider(
            value = sliderColorsG,
            onValueChange = { sliderColorsG = it },
            valueRange = 0f..1f
        )
    }
}