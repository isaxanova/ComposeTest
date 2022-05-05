import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Login()
    }
}

@Composable
@Preview
fun Login() {
    var login = "sonia"
    var password = "123"
    var inputLogin by rememberSaveable { mutableStateOf("") }
    var inputPassword by rememberSaveable { mutableStateOf("") }
    var resultColor by rememberSaveable { mutableStateOf(Color.White) }
    var resultText by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.padding(50.dp)) {

        TextField(
            value = inputLogin,
            onValueChange = {
                inputLogin = it
            },
            label = { Text("Login") }
        )
        TextField(
            value = inputPassword,
            onValueChange = {
                inputPassword = it
            },
            label = { Text("Password") }
        )
        Button(
            content = { Text("Log in") },
            onClick = {
                if (login == inputLogin && password == inputPassword) {
                    resultText = "успех"
                    resultColor = Color.Green
                } else {
                    resultText = "ошибка"
                    resultColor = Color.Red
                }
            }
        )
        Text(text = resultText, color = resultColor)

    }


}