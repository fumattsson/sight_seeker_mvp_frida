package data

import kotlinx.serialization.Serializable

@Serializable
data class DistanceData(
    val distanceOptions: List<String>,
)