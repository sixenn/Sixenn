package dev.nekkan.sixenn.config

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.File

@Serializable
data class DiscordConfigWrapper(val discord: DiscordConfig)

@Serializable
data class DiscordConfig(
    val token: String,
    @SerialName("application_id")
    val applicationId: Long,
    @SerialName("testing_server_id")
    val testingServerId: Long,
    @SerialName("public_key")
    val publicKey: String,
    @SerialName("interactions_port")
    val interactionsPort: Short
) {

    companion object {
        private val value by lazy {
            val slash = File.separator
            val text = File("${System.getProperty("user.home")}$slash.sixenn${slash}discord.yml").readText()
            Yaml.default.decodeFromString(DiscordConfigWrapper.serializer(), text)
        }

        operator fun invoke() = value.discord
    }

}
