@file:JvmName("SixennConfiguration")

package dev.nekkan.sixenn.platforms.discord.common

import com.typesafe.config.ConfigFactory
import dev.kord.common.entity.Snowflake
import dev.nekkan.sixenn.common.configuration.BaseSixennAuthenticator
import dev.nekkan.sixenn.common.configuration.BaseSixennConfiguration
import dev.nekkan.sixenn.common.utils.files.home
import dev.nekkan.sixenn.common.utils.files.readFile
import io.github.config4k.extract

data class DiscordSixennConfiguration(
    val discord: SixennDiscordConfig,
    val database: SixennDatabaseConfig
) : BaseSixennConfiguration<DiscordSixennIdentification, BaseSixennAuthenticator> {

    companion object {

        val INSTANCE by lazy {
            ConfigFactory.parseString(
                readFile(
                    "$home/sixenn/${
                        if (System.getProperty("environment", "dev").equals("prod", true))
                            "sixenn.production.conf"
                        else
                            "sixenn.conf"
                    }"
                )
            ).extract<DiscordSixennConfiguration>()
        }

        inline operator fun invoke() = INSTANCE

    }

    override val authenticator: BaseSixennAuthenticator
        get() = BaseSixennAuthenticator(discord.token)

    override val ownerIdentification: DiscordSixennIdentification
        get() = DiscordSixennIdentification(Snowflake(discord.ownerId))

    override val defaultPrefix: String
        get() = discord.defaultPrefix

}

data class SixennDatabaseConfig(
    val user: String,
    val password: String,
    val host: String,
    val port: String,
    val database: String
)

data class SixennDiscordConfig(
    val ownerId: Long,
    val defaultPrefix: String,
    val token: String,
    val server: SixennPortConfig
)

data class SixennPortConfig(val port: Int)
