// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


var input1 = 0f
var input2 = 0f
var resalt = 0f

@Composable
@Preview
fun App() {
    var text by rememberSaveable { mutableStateOf("Глупышка") }
    var textcontent1 by rememberSaveable { mutableStateOf("") }
    var textcontent2 by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.padding(30.dp)) {

        TextField(
            value = textcontent1,
            onValueChange = {
                textcontent1 = it

            },
            label = { Text("введите 1-е число") })

        TextField(
            value = textcontent2,
            onValueChange = {
                textcontent2 = it

            },
            label = { Text("введите 2-е число") })
        Row {
            Button(
                modifier = Modifier.padding(0.dp),
                content = { Text("+") },
                onClick = {
                    input1 = textcontent1.toFloat()
                    input2 = textcontent2.toFloat()
                    resalt = input1 + input2

                    text = "$input1 + $input2 = $resalt"
                }
            )

            Button(
                modifier = Modifier.padding(start = 15.dp),
                content = { Text("*") },
                onClick = {
                    input1 = textcontent1.toFloat()
                    input2 = textcontent2.toFloat()
                    resalt = input1 * input2

                    text = "$input1 * $input2 = $resalt"
                }
            )

            Button(
                modifier = Modifier.padding(start = 15.dp),
                content = { Text(":") },
                onClick = {
                    input1 = textcontent1.toFloat()
                    input2 = textcontent2.toFloat()
                    resalt = input1 / input2

                    text = "$input1 : $input2 = $resalt"
                }
            )

            Button(
                modifier = Modifier.padding(start = 15.dp),
                content = { Text("^") },
                onClick = {
                    input1 = textcontent1.toFloat()
                    input2 = textcontent2.toFloat()
                    resalt = 1f

                    repeat(input2.toInt()) {
                        resalt = resalt * input1
                    }

                    text = "$input1 ^ $input2 = $resalt"
                }
            )
        }

        Text(text)

    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
