package dev.nekkan.sixenn.platforms.discord.commands

import dev.nekkan.sixenn.common.command.BaseCommandContext
import dev.nekkan.sixenn.common.command.arguments.Argument
import dev.nekkan.sixenn.platforms.discord.entities.DiscordMessage
import dev.nekkan.sixenn.platforms.discord.entities.DiscordUser

data class DiscordCommandContext(
    override val arguments: List<Argument<*>>,
    override val author: DiscordUser,
    override val message: DiscordMessage
) : BaseCommandContext<DiscordUser, DiscordMessage>
