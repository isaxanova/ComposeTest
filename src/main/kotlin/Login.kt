import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
            modifier = Modifier.align(Alignment.CenterHorizontally),
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

        Box(modifier = Modifier.background(Color.Gray).width(300.dp).height(150.dp),
            content = {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, Modifier.align(Alignment.TopCenter))

            })
    }


}