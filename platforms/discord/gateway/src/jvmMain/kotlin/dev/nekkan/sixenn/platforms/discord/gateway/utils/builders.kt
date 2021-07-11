@file:JvmName("Builders")

package dev.nekkan.sixenn.platforms.discord.gateway.utils

import dev.kord.x.commands.kord.model.context.KordCommandEvent
import dev.nekkan.sixenn.common.command.arguments.Argument
import dev.nekkan.sixenn.platforms.discord.common.context.DiscordCommandContext
import dev.nekkan.sixenn.platforms.discord.common.entities.DiscordMessage
import dev.nekkan.sixenn.platforms.discord.common.entities.DiscordUser

inline fun KordCommandEvent.context(vararg arguments: Argument<*>) = DiscordCommandContext(
    arguments.toList(), DiscordUser(author.id.identification, author), DiscordMessage(message)
)
