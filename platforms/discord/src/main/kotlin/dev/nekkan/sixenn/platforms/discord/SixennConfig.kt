package dev.nekkan.sixenn.platforms.discord

@JvmInline
value class SixennConfig(val sixenn: InternalSixennConfig)

data class InternalSixennConfig(
    val discord: SixennDiscordConfig,
    val defaultPrefix: String,
    val ownerId: Long
)

data class SixennDiscordConfig(
    val token: String
)
