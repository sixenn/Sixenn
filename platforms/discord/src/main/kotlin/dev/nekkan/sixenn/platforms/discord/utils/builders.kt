@file:JvmName("Builders")

package dev.nekkan.sixenn.platforms.discord.utils

import dev.kord.x.commands.kord.model.context.KordCommandEvent
import dev.nekkan.sixenn.common.command.arguments.Argument
import dev.nekkan.sixenn.platforms.discord.commands.DiscordCommandContext
import dev.nekkan.sixenn.platforms.discord.entities.DiscordMessage
import dev.nekkan.sixenn.platforms.discord.entities.DiscordUser

inline fun KordCommandEvent.context(vararg arguments: Argument<*>) = DiscordCommandContext(
    arguments.toList(), DiscordUser(author.id.identification, author), DiscordMessage(message)
)
