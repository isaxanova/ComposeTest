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
        displayText()
    }
}

@Composable
@Preview
fun displayText() {
    var inputText1 by rememberSaveable { mutableStateOf("") }
    var resultText by rememberSaveable { mutableStateOf("") }
    var inputText2 by rememberSaveable { mutableStateOf("") }
    Row {
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            TextField(
                value = inputText1,
                onValueChange = {
                    inputText1 = it
                }
            )
            TextField(
                value = inputText2,
                onValueChange = {
                    inputText2 = it
                }
            )
        }
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            Button(
                content = { Text("Clone") },
                onClick = {
                    resultText = duplicateText(inputText1)
                }
            )
            Button(
                content = { Text("Result + previus") },
                onClick = {
                    resultText = summa(resultText, inputText1)
                }
            )
            Button(
                content = { Text("Сумма чисел") },
                onClick = {
                    var input1 = inputText1.toFloat()
                    var input2 = inputText2.toFloat()
                    var result: Float = input1 + input2

                    resultText = result.toString()
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

fun summa(text1: String, text2: String): String {
    return text1 + " " + text2
}