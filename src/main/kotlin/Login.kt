import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

}