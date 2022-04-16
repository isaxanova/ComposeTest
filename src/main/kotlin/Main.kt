// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

var i: Int = 0

@Composable
@Preview
fun App() {

    Column(modifier = Modifier.padding(30.dp)) {
        Button(
            content = { displayRows() },
            onClick = {

                i =i+1
                sthg(i)

            }
        )


        displayRows()
    }
}

@Composable
private fun displayRows() {
    Column {
        Row(modifier = Modifier.padding(30.dp)) {
            displayColumn()
            displayColumn()
            displayColumn()
        }
        Row(modifier = Modifier.padding(30.dp)) {
            displayColumn()
            displayColumn()
            displayColumn()
        }

        Row(modifier = Modifier.padding(30.dp)) {
            displayColumn()
            displayColumn()
            displayColumn()
        }
    }
}

fun sthg(value: Int) {
    println("что-то произошло $value")
}

@Composable
private fun displayColumn() {
    Column(modifier = Modifier.padding(horizontal = 50.dp)) {
        Text("Пуся")
        Text("пришел")
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
