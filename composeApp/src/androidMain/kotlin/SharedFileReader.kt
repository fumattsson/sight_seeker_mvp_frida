import androidx.compose.ui.tooling.data.UiToolingDataApi
import java.io.InputStreamReader

@OptIn(UiToolingDataApi::class)
internal actual class SharedFileReader{
    actual fun loadJsonFile(fileName: String): String? {
        return javaClass.classLoader?.getResourceAsStream(fileName).use { stream ->
            InputStreamReader(stream).use { reader ->
                reader.readText()
            }
        }
    }
}