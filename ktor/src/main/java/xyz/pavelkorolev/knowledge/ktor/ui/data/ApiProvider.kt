package xyz.pavelkorolev.knowledge.ktor.ui.data

import io.ktor.client.HttpClient

class ApiProvider {

    private val client = HttpClient()

    val catApi: CatApi get() = CatApiImpl(BASE_URL, client)

    companion object {
        private const val BASE_URL = "https://cat-fact.herokuapp.com"
    }

}
