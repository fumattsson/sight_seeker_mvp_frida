package data

import kotlinx.serialization.Serializable

@Serializable
data class ContentData(
    val welcomeTo: String,
    val nearbyAttractions: String,
)