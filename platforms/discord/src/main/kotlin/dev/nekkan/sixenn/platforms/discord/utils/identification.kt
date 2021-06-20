@file:JvmName("Identification")

package dev.nekkan.sixenn.platforms.discord.utils

import dev.kord.common.entity.Snowflake
import dev.nekkan.sixenn.platforms.discord.config.DiscordSixennIdentification

inline val Snowflake.identification get() = DiscordSixennIdentification(this)
