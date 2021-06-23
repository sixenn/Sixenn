package dev.nekkan.sixenn.platforms.discord.common

import dev.kord.common.entity.Snowflake
import dev.nekkan.sixenn.common.configuration.BaseSixennIdentification

@JvmInline
value class DiscordSixennIdentification(override val value: Snowflake) : BaseSixennIdentification<Snowflake>
