package xyz.pavelkorolev.knowledge.ktor.ui.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class ApiProvider {

    private val client = HttpClient(OkHttp) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                Json(
                    JsonConfiguration.Stable.copy(
                        ignoreUnknownKeys = true
                    )
                )
            )
        }
    }

    val catApi: CatApi get() = CatApiImpl(BASE_URL, client)

    companion object {
        private const val BASE_URL = "https://cat-fact.herokuapp.com"
    }

}
