package dev.nekkan.sixenn.platforms.discord

import dev.kord.common.entity.Snowflake
import dev.nekkan.sixenn.common.configuration.BaseSixennAuthenticator
import dev.nekkan.sixenn.common.configuration.BaseSixennConfiguration
import dev.nekkan.sixenn.platforms.discord.config.DiscordSixennIdentification

data class DiscordSixennConfiguration(
    val discord: SixennDiscordConfig,
) : BaseSixennConfiguration<DiscordSixennIdentification, BaseSixennAuthenticator> {

    override val authenticator: BaseSixennAuthenticator
        get() = BaseSixennAuthenticator(discord.token)

    override val ownerIdentification: DiscordSixennIdentification
        get() = DiscordSixennIdentification(Snowflake(discord.ownerId))

    override val defaultPrefix: String
        get() = discord.defaultPrefix

}

data class SixennDiscordConfig(
    val ownerId: Long,
    val defaultPrefix: String,
    val token: String
)
