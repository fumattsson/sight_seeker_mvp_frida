package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import navigation.MainScreenComponent
import androidx.compose.ui.unit.dp
import components.listItem
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val primaryColor = Color(0xFF45BFE4)
val secondaryColor = Color(0xFFE6F2F4)
val backgroundColor = Color(0xFFF3F8F9)
val textColor = Color(0xFF111417)
val accentColor = Color(0xFFFF8800)
// declare
val primaryBgColor = Color(0x3B45BFE4)

class item(val header: String, val content: String, val time: String)

val lists = arrayOf(
    item("Empire State Building", "231 East 95th Street, HK", "2.8mi"),
    item("Rockefello Center", "231 East 95th Street, HK", "3.8mi"),
    item("Central Park", "231 East 95th Street, HK", "4.8mi"),
    item("The High Line", "231 East 95th Street, HK", "4.8mi"),
    item("Flatiron Building", "231 East 95th Street, HK", "4.8mi"),
    item("Statue of Library", "231 East 95th Street, HK", "4.8mi"),
    item("Empire State Building", "231 East 95th Street, HK", "4.8mi"),
    item("Empire State Building", "231 East 95th Street, HK", "4.8mi"),
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreen(component: MainScreenComponent) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(screens.backgroundColor)
            .padding(30.dp, 50.dp, 30.dp, 0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(text = "Welcome to New York!", fontSize = 32.sp, fontWeight = FontWeight.Black)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .height(IntrinsicSize.Max)
                    .padding(10.dp)
                    .background(color = primaryBgColor, shape = RoundedCornerShape(20.dp)),
                verticalAlignment = Alignment.CenterVertically,
            ) {


                Row(
                    modifier = Modifier
                        .width(40.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource("location_on.png"),
                        contentDescription = "My Icon",
                        modifier = Modifier.size(24.dp),
                    )
                }

                Text(
                    modifier = Modifier.padding(5.dp, 16.dp, 16.dp, 16.dp),
                    text = "New York, USA",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .height(IntrinsicSize.Max)
                    .padding(10.dp)
                    .background(color = primaryBgColor, shape = RoundedCornerShape(20.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                Row(
                    modifier = Modifier
                        .width(40.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource("schedule.png"),
                        contentDescription = "My Icon",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    modifier = Modifier.padding(5.dp, 16.dp, 16.dp, 16.dp),
                    text = "3.5km",
                    color = Color.Black,
                    fontSize = 16.sp,
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
                Text(text = "Nearest Places", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                for(item in lists) {
                    println(item.header)
                    listItem(item.header, item.content, item.time)
                }
            }
        }


//        Button(onClick = {
//            component.goBack()
//        }) {
//            Text("Go back")
//        }
    }
}
