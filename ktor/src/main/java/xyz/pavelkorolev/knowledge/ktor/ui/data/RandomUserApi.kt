package xyz.pavelkorolev.knowledge.ktor.ui.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import xyz.pavelkorolev.knowledge.ktor.ui.entities.RandomUser
import xyz.pavelkorolev.knowledge.ktor.ui.entities.RandomUserResponse

interface RandomUserApi {

    suspend fun getUsers(amount: Int): List<RandomUser>

}

class RandomUserApiImpl(
    private val client: HttpClient
) : RandomUserApi {

    override suspend fun getUsers(
        amount: Int
    ): List<RandomUser> = client.get<RandomUserResponse>(BASE_URL) {
        parameter("results", amount)
    }.result

    companion object {
        private const val BASE_URL = "https://randomuser.me/api/"
    }

}
