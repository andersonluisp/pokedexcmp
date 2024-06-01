package data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Ktor {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"
    val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(json = Json { ignoreUnknownKeys = true })
        }
        defaultRequest {
            url(BASE_URL)
        }
    }

    suspend inline fun <reified T> getEntireUrl(url: String): T {
        return HttpClient{
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true })
            }
        }.get(url).body<T>()
    }
}