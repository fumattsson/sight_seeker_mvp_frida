package screens

import SharedFileReader
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import navigation.MainScreenComponent
import androidx.compose.ui.unit.dp
import components.AttractionListItem
import data.ContentData
import data.LocationData
import kotlinx.serialization.json.Json
import navigation.MainScreenEvent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val backgroundColor = Color(0xFFF3F8F9)
val primaryBgColor = Color(0x3B45BFE4)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreen(component: MainScreenComponent) {

    // Load current location data from local json file and parse as LocationData
    val locationJsonFile = SharedFileReader().loadJsonFile("locationData.json")
    val location = locationJsonFile?.let { Json.decodeFromString<LocationData>(it) }

    // Load strings from local json file and parse as ContentData
    val contentJsonFile = SharedFileReader().loadJsonFile("contentData.json")
    val content = contentJsonFile?.let { Json.decodeFromString<ContentData>(it) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(30.dp, 50.dp, 30.dp, 0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "${content!!.welcomeTo} ${location!!.name}!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier.pointerInput(Unit) {
                detectTapGestures (
                    onDoubleTap = {
                        component.onEvent(MainScreenEvent.NavigateToErrorScreen)
                    }
                )
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .height(IntrinsicSize.Max)
                    .padding(8.dp)
                    .background(color = primaryBgColor, shape = RoundedCornerShape(20.dp)),
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
                    text = location.name,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .height(IntrinsicSize.Max)
                    .padding(8.dp)
                    .background(color = primaryBgColor, shape = RoundedCornerShape(20.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                Row(
                    modifier = Modifier
                        .width(40.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource("distance.png"),
                        contentDescription = "My Icon",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )
                }

                Text(
                    modifier = Modifier.padding(0.dp, 10.dp, 16.dp, 10.dp),
                    text = "1.5km",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = content.nearbyAttractions, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(0.dp, 0.dp, 0.dp,20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                for(attractionItem in location.touristAttractions) {
                    AttractionListItem(attractionItem.name, attractionItem.address, attractionItem.distance)
                }
            }
        }
    }
}
