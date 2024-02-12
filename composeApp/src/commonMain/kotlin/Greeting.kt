import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

fun CanvasDrawScope.asBitmap(size: Size, onDraw: DrawScope.() -> Unit): ImageBitmap {
    val bitmap = ImageBitmap(size.width.toInt(), size.height.toInt())
    draw(Density(1f), LayoutDirection.Ltr, Canvas(bitmap), size) { onDraw() }
    return bitmap
}


fun drawToBitmap(): ImageBitmap {
    val drawScope = CanvasDrawScope()
    val size = Size(400f, 400f)
    val bitmap = drawScope.asBitmap(size) {
        // Draw whatever you want here; for instance, a white background and a red line.
        drawRect(color = Color.White, topLeft = Offset.Zero, size = size)
        drawLine(
            color = Color.Red,
            start = Offset.Zero,
            end = Offset(size.width, size.height),
            strokeWidth = 5f
        )

    }

    return bitmap
}
