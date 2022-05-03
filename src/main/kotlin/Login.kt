import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
        Login()
    }
}

@Composable
@Preview
fun Login() {
    var login = "sonia"
    var password = "123"
    var text1 by rememberSaveable { mutableStateOf("") }
    var text2 by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.padding(50.dp)) {

        TextField(
            value = text1,
            onValueChange = {
                text1 = it
            },
            label = { Text("Login")}
        )
        TextField(
            value = text2,
            onValueChange = {
                text2 = it
            },
            label = { Text("Password")}
        )

    }


}