package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.AttractionDetailsScreenComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AttractionDetailsScreen (component: AttractionDetailsScreenComponent) {
    val name = component.attractionName.subscribeAsState()
    val description = component.attractionDescription.subscribeAsState()

    IconButton(onClick = {
        component.goBack()
    }) {
        Icon(
            painter = painterResource("arrow_back.png"),
            contentDescription = "My Icon",
            modifier = Modifier.size(20.dp),
            tint = Color.Unspecified
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize().padding(20.dp, 60.dp, 20.dp, 0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text ="${name.value}",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text("${description.value}")
    }
}