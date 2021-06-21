@file:JvmName("PingCommand")
@file:AutoWired
package dev.nekkan.sixenn.platforms.discord.commands.misc

import dev.kord.x.commands.annotation.AutoWired
import dev.kord.x.commands.annotation.ModuleName
import dev.kord.x.commands.kord.module.command
import dev.kord.x.commands.model.command.invoke
import dev.nekkan.sixenn.commands.miscellaneous.PigExecutor
import dev.nekkan.sixenn.commands.miscellaneous.PingExecutor
import dev.nekkan.sixenn.platforms.discord.SixennDiscord
import dev.nekkan.sixenn.platforms.discord.commands.DiscordCommandContext
import dev.nekkan.sixenn.platforms.discord.sixenn
import dev.nekkan.sixenn.platforms.discord.utils.context

@ModuleName("ping-command")
fun pingCommand() = command("ping") {
    val executor = PingExecutor<SixennDiscord, DiscordCommandContext>()
    invoke {
        executor.execute(sixenn, context())
    }
}


@ModuleName("pig-command")
fun pigCommand() = command("pig") {
    alias(":pig:", "\uD83D\uDC37")
    val executor = PigExecutor<SixennDiscord, DiscordCommandContext>()
    invoke {
        executor.execute(sixenn, context())
    }
}