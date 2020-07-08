package xyz.pavelkorolev.knowledge.ktor.ui.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class ApiProvider(
    private val isDebug: Boolean
) {

    private val client: HttpClient by lazy {
        createClient()
    }

    val catApi: CatApi get() = CatApiImpl(client)

    val randomUserApi: RandomUserApi get() = RandomUserApiImpl(client)

    private fun createClient(): HttpClient = HttpClient(OkHttp) {
        if (isDebug) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d("API", message)
                    }
                }
                level = LogLevel.BODY
            }
        }
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

}
