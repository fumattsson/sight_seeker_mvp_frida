package components

import SharedFileReader
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.DistanceData
import kotlinx.serialization.json.Json
import screens.primaryColor
import screens.secondaryColor

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DistanceDropdownMenu () {

    // Load strings from local json file and parse as DistanceData
    val distanceJsonFile = SharedFileReader().loadJsonFile("distanceData.json")
    val distance = distanceJsonFile?.let { Json.decodeFromString<DistanceData>(it) }

    //states related to dropdown menu
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var distances by remember {
        mutableStateOf(distance!!.distanceOptions[0])
    }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it }
    ) {
        TextField(
            value = distances,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,

                ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding(0.dp).height(50.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = primaryColor,
                trailingIconColor = secondaryColor,
                focusedIndicatorColor = Color.Unspecified,
                unfocusedIndicatorColor = Color.Unspecified
            ),
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
        ) {
            for (menuItem in distance!!.distanceOptions) {
                DropdownMenuItem(
                    content = {
                        Text(text = menuItem)
                    },
                    onClick = {
                        distances = menuItem
                        isExpanded = false
                    }
                )
            }
        }
    }
}