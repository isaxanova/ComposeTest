// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                    text="отправлено"

                }
            )
            Text(text = textcontent2)
        }
    }
}
