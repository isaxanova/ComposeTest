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


private var input1 = 0f
private var input2 = 0f
private var resalt = 0f

fun button1(textcontent1: String, textcontent2: String): String {
    val input1 = textcontent1.toFloat()
    val input2 = textcontent2.toFloat()
    return "${input1 + input2}"
}

fun botton2(b: String, a: String): String {
    input1 = a.toFloat()
    input2 = b.toFloat()
    return "${input1 * input2}"
}

@Composable
@Preview
fun displayCalculationColumn(){
    var text by rememberSaveable { mutableStateOf("Глупышка") }
    var textcontent1: String by rememberSaveable { mutableStateOf("") }
    var textcontent2: String by rememberSaveable { mutableStateOf("") }

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

            Button(
                modifier = Modifier.padding(start = 0.dp),
                content = { Text("*") },
                onClick = {
                    text = botton2(textcontent1, textcontent2)
                }
            )
            Button(
                modifier = Modifier.padding(start = 15.dp),
                content = { Text("+") },
                onClick = {
                    text = button1(textcontent1, textcontent2)
                }
            )
        }
        Text(text)
    }
}