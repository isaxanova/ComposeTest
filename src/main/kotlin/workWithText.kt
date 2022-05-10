import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
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
                    resultText = previousPlusCurrent(resultText, inputText1)
                }
            )
            Button(
                content = { Text("Сумма чисел") },
                onClick = {
                    resultText = summ(text1 = inputText1, text2 = inputText2)
                }
            )
            Button(
                content = { Text("добропожаловать в город") },
                onClick = {
                    resultText = nameAria(text1 = inputText1, text2 = inputText2)
                }
            )
            Button(
                content = { Text("Получить первую букву") },
                onClick = {
                    resultText = inputText1[0].toString()
                }
            )
            Button(
                content = { Text("Получить Инициалы") },
                onClick = {
                    resultText = initials(text1 = inputText1, text2 = inputText2)
                }
            )
            Button(
                content = { Text("Напечатать все буквы") },
                onClick = {
                    printAllLetters(inputText1)
                }
            )
            Button(
                content = { Text("Напечатать четные буквы") },
                onClick = {
                    resultText = printEven(inputText1)
                }
            )
            Button(
                content = { Text("Напечатать нечетные буквы") },
                onClick = {
                    resultText = printOdd(inputText1)
                }
            )
            Button(
                content = { Text("Напечатать кратные буквы") },
                onClick = {
                    resultText = printText2(inputText1, inputText2)
                }
            )
            Button(
                content = { Text("Нарисовать звездочки") },
                onClick = {
                    resultText = printStars(inputText1, inputText2)
                }
            )
            Button(
                content = { Text("Нарисовать  матрицу") },
                onClick = {
                    resultText = printMathrics(inputText1, inputText2)
                }
            )
        }
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            SelectionContainer { Text(resultText) }
        }
    }
}

fun duplicateText(text: String): String {
    return text + " " + text
}

fun previousPlusCurrent(text1: String, text2: String): String {
    return text1 + " " + text2
}

fun summ(text1: String, text2: String): String {
    val input1 = text1.toFloat()
    val input2 = text2.toFloat()
    val result: Float = input1 + input2
    return result.toString()
}

fun nameAria(text1: String, text2: String): String {
    val result = text1 + ", добропожаловать в город " + text2
    return result
}

fun initials(text1: String, text2: String): String {
    return text1[0].toString() + ". " + text2[0].toString() + "."
}

fun printAllLetters(text: String) {
    println(" Длина текста = ${text.length}")

    for (index in 0..text.length - 1) {
        println("" + index + ": " + text[index])
    }
}

fun printEven(text: String): String {
    var temp = ""
    for (index in 0..text.length - 1) {
        if (index % 2 == 0) {
            temp = temp + text[index]
        }
    }
    return temp
}

fun printOdd(text: String): String {
    var temp = ""
    for (index in 0..text.length - 1) {
        if (index % 2 != 0) {
            temp = temp + text[index]
        }
    }
    return temp
}

fun printText2(text1: String, text2: String): String {
    val number = text2.toInt()
    var temp = ""
    for (index in 0..text1.length - 1) {
        if (index % number == 0) {
            temp = temp + text1[index]
        }
    }
    return temp
}

fun printStars(text1: String, text2: String): String {
    var numberLines = text1.toInt()
    var number = text2.toInt()
    var stars: String = ""
    for (index in 1..number) {
        stars = stars + "*"
    }
    var lines = ""
    for (index in 1..numberLines) {
        lines = lines + stars + "\n"
    }

    return lines
}

fun printMathrics(text1: String, text2: String):String {
    var numberOfRows = text1.toInt()
    var numberOfColumns = text2.toInt()

    var result = ""
    for (indexC in 0..numberOfColumns-1) {
        for (indexR in 0..numberOfRows-1) {

            result = result + "["+indexC+":"+indexR+ "] "

        }
        result=result+"\n"
    }
    return result
}