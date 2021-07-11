package dev.nekkan.sixenn.platforms.discord.gateway.commands

import dev.nekkan.sixenn.common.command.BaseCommandContext
import dev.nekkan.sixenn.common.command.arguments.Argument
import dev.nekkan.sixenn.platforms.discord.common.entities.DiscordMessage
import dev.nekkan.sixenn.platforms.discord.common.entities.DiscordUser

data class DiscordCommandContext(
    override val arguments: List<Argument<*>>,
    override val author: DiscordUser,
    override val message: DiscordMessage
) : BaseCommandContext<DiscordUser, DiscordMessage>
