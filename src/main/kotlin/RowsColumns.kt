import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
 fun displayRows() {
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
