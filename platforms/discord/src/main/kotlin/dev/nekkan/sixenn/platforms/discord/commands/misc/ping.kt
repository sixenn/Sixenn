@file:JvmName("PingCommand")
@file:AutoWired
package dev.nekkan.sixenn.platforms.discord.commands.misc

import dev.kord.x.commands.annotation.AutoWired
import dev.kord.x.commands.annotation.ModuleName
import dev.kord.x.commands.kord.module.command
import dev.kord.x.commands.model.command.invoke

@ModuleName("ping-command")
fun pingCommand() = command("ping") {
    invoke {
        respond("Pong!")
    }
}


@ModuleName("pig-command")
fun pigCommand() = command("pig") {
    alias(":pig:", "\uD83D\uDC37")
    invoke {
        respond("Pog! <:pog:856141928029356036>")
    }
}