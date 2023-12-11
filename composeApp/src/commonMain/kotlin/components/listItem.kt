package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val secondaryColor = Color(0xFFE6F2F4)
val primaryBgColor = Color(0x3B45BFE4)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun listItem (header: String, content: String, strTime: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .padding(20.dp, 0.dp, 0.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
            ) {
                Text(text = header, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = content, fontSize = 16.sp, color = screens.secondaryColor)
            }
        }

        Row(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = strTime, fontSize = 14.sp, color = screens.secondaryColor, textAlign = TextAlign.End)
            }

            Box(
                modifier = Modifier
                    .background(screens.primaryBgColor, shape = RoundedCornerShape(0.dp ,20.dp, 20.dp, 0.dp))
                    .width(50.dp)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource("arrow_forward.png"),
                    contentDescription = "My Icon",
                    modifier = Modifier.size(28.dp)
                )
            }
        }


    }
}