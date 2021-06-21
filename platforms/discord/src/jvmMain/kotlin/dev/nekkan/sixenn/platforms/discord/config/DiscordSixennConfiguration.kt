package dev.nekkan.sixenn.platforms.discord

import dev.kord.common.entity.Snowflake
import dev.nekkan.sixenn.common.configuration.BaseSixennAuthenticator
import dev.nekkan.sixenn.common.configuration.BaseSixennConfiguration
import dev.nekkan.sixenn.platforms.discord.config.DiscordSixennIdentification

@JvmInline
value class DiscordSixennConfiguration(val sixenn: InternalSixennConfig) :
    BaseSixennConfiguration<DiscordSixennIdentification, BaseSixennAuthenticator> {

    override val defaultPrefix: String
        get() = sixenn.defaultPrefix

    override val authenticator: BaseSixennAuthenticator
        get() = BaseSixennAuthenticator(sixenn.discord.token)

    override val ownerIdentification: DiscordSixennIdentification
        get() = DiscordSixennIdentification(Snowflake(sixenn.ownerId))

}

data class InternalSixennConfig(
    val discord: SixennDiscordConfig,
    val defaultPrefix: String,
    val ownerId: Long
)

data class SixennDiscordConfig(
    val token: String
)
