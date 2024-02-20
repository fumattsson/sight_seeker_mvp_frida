package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.primaryColor

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CurrentLocationBox (locationName: String) {
    Row(
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .height(64.dp)
            .padding(8.dp)
            .background(color = primaryColor, shape = RoundedCornerShape(20.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier
                .width(40.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource("location.png"),
                contentDescription = "My Icon",
                modifier = Modifier.size(16.dp),
                tint = Color.Unspecified
            )
        }

        Text(
            modifier = Modifier.padding(0.dp, 10.dp, 16.dp, 10.dp),
            text = locationName,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}