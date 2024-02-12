import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun App() {
    val image = remember { drawToBitmap() }

    MaterialTheme {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawImage(image)
        }
    }
}