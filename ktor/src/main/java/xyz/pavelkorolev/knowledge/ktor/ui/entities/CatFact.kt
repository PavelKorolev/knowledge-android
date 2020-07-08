package xyz.pavelkorolev.knowledge.ktor.ui.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatFact(

    @SerialName(value = "text")
    val text: String? = null

)
