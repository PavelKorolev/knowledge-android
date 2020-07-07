package xyz.pavelkorolev.knowledge.ktor.ui.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import xyz.pavelkorolev.knowledge.ktor.ui.entities.CatFact

interface CatApi {

    suspend fun getFact(amount: Int): List<CatFact>

}

class CatApiImpl(
    private val baseUrl: String,
    private val client: HttpClient
) : CatApi {

    override suspend fun getFact(amount: Int): List<CatFact> = client.get(
        "$baseUrl/facts/random?animal_type=cat&amount=$amount"
    )

}

