package screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import navigation.ErrorScreenComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.minimumInteractiveComponentSize
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ErrorScreen(component: ErrorScreenComponent) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Opps, something went wrong...\n Please try again",
            modifier = Modifier.padding(bottom = 10.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
        )

       Image(
           painter = painterResource("maskgroup.png"),
           contentDescription = "Small reset button image",
           modifier = Modifier.size(30.dp).padding(bottom = 10.dp)
           )

        Image(
            painter = painterResource("sightseekererror.png"),
            contentDescription = "Something went wrong image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )


        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(onClick = {
                component.goBack()
            }) {
                Text("Go back")


        }
    }
}
