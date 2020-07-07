package xyz.pavelkorolev.knowledge.ktor.ui.entities

import kotlinx.serialization.Serializable

@Serializable
data class CatFact(
    val text: String? = null
)
