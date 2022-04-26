// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
@Preview
fun App() {
    var textcontent2: String by rememberSaveable { mutableStateOf("") }
    var text: String by rememberSaveable { mutableStateOf("отправить") }

    Row {
        displayCalculationColumn()
        Column {
            TextField(
                value = textcontent2,
                onValueChange = {
                    textcontent2 = it
                    println(it)
                }
            )
            Button(
                modifier = Modifier.padding(start = 15.dp),
                content = { Text(text) },
                onClick = {
                    text = "отправлено"

                }
            )
            Text(text = textcontent2)

            var sliderPosition by remember { mutableStateOf(0f) }
            var sliderColors by remember { mutableStateOf(0f) }
            Box(Modifier.width(sliderPosition.dp).height(200.dp).background(color = Color(sliderColors,sliderColors,sliderColors)))
            Column {
                Text(text = "Текущее значение: ${sliderPosition}", fontSize = 22.sp)
                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it },
                    valueRange = 0f..200f
                )
            }

            Column  {
                Text(text = "Текущее значение: ${sliderColors}", fontSize = 22.sp)
                Slider(
                    value = sliderColors,
                    onValueChange = { sliderColors = it },
                    valueRange = 0f..1f
                )
            }

        }
    }
}
