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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        displayText()
    }
}

@Composable
@Preview
fun displayText() {
    var inputText by rememberSaveable { mutableStateOf("") }
    var resultText by rememberSaveable { mutableStateOf("") }
    Row {
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            TextField(
                value = inputText,
                onValueChange = {
                    inputText = it
                }
            )
        }
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            Button(
                content = { Text("Clone") },
                onClick = {
                    resultText = duplicateText(inputText)//inputText + " " + inputText
                }
            )
            Button(
                content = { Text("Result + previus") },
                onClick = {
                    resultText = summa(resultText,inputText)//inputText + " " + inputText
                }
            )
        }
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            Text(resultText)
        }
    }
}

fun duplicateText(text: String): String {
    return text + " " + text
}
fun summa (text1:String,text2:String): String {
    return text1 +" "+ text2
}