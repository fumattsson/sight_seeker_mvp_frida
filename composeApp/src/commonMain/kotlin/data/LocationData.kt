package data

import kotlinx.serialization.Serializable

@Serializable
data class LocationData(
    val name: String,
    val touristAttractions: List<TouristAttraction>
)
@Serializable
data class TouristAttraction(
    val name: String,
    val address: String,
    val distance: String
)