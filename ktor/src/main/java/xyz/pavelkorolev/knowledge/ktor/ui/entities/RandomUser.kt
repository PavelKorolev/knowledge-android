package xyz.pavelkorolev.knowledge.ktor.ui.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUserResponse(

    @SerialName(value = "results")
    val result: List<RandomUser>

)

@Serializable
data class RandomUser(

    @SerialName(value = "name")
    val name: RandomUserName

)

@Serializable
data class RandomUserName(

    @SerialName(value = "first")
    val first: String,

    @SerialName(value = "last")
    val last: String

)
