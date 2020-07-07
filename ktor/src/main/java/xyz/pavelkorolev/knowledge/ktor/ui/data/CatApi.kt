package xyz.pavelkorolev.knowledge.ktor.ui.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get

interface CatApi {

    suspend fun getFact(): String

}

class CatApiImpl(
    private val baseUrl: String,
    private val client: HttpClient
) : CatApi {

    override suspend fun getFact(): String = client.get(
        "$baseUrl/facts/random?animal_type=cat&amount=2"
    )

}
