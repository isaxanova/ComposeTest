// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        displayCalculationColumn()
    }
}

@Composable
@Preview
fun App() {

    Row {
        var firstButton = ButtenWithText(Icons.Rounded.Menu, "MENU")
        var secondButton = ButtenWithText(Icons.Rounded.Add, "ADD")
        var thirdButton = ButtenWithText(Icons.Default.Share, "SHARE")
        ColumnButten(firstButton, secondButton, thirdButton)

        var fourButton = ButtenWithText(Icons.Rounded.Menu, "MENU")
        var fiveButton = ButtenWithText(Icons.Rounded.Add, "ADD")
        var sixButton = ButtenWithText(Icons.Default.Share, "SHARE")

        ColumnButten(fourButton, fiveButton, sixButton)

    }
}

@Composable
fun ColumnButten(param1: ButtenWithText, param2: ButtenWithText, param3: ButtenWithText) {
    Column {
        displayButtenWithText(param1)
        displayButtenWithText(param2)
        displayButtenWithText(param3)
    }
}

@Composable
fun displayButtenWithText(param: ButtenWithText) {
    Button(
        content = {
            Icon(imageVector = param.icon, contentDescription = null)
            Text(param.text)
        },
        onClick = {
            param.nameOnParams()
        }
    )
}

class ButtenWithText(
    var icon: ImageVector,
    var text: String,
) {
    fun nameOnParams() {
        println(" этого экземпляра параметр текст =$text")
    }
}

