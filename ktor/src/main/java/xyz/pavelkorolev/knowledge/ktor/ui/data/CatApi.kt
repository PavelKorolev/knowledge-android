package xyz.pavelkorolev.knowledge.ktor.ui.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import xyz.pavelkorolev.knowledge.ktor.ui.entities.CatFact

interface CatApi {

    suspend fun getFacts(amount: Int): List<CatFact>

}

class CatApiImpl(
    private val client: HttpClient
) : CatApi {

    override suspend fun getFacts(
        amount: Int
    ): List<CatFact> = client.get("$BASE_URL/facts/random") {
        parameter("animal_type", "cat")
        parameter("amount", amount)
    }

    companion object {
        private const val BASE_URL = "https://cat-fact.herokuapp.com"
    }

}

