@file:JvmName("PingCommand")
@file:AutoWired
package dev.nekkan.sixenn.platforms.discord.commands.exclusive.misc

import dev.kord.common.Color
import dev.kord.core.behavior.edit
import dev.kord.core.entity.Message
import dev.kord.x.commands.annotation.AutoWired
import dev.kord.x.commands.annotation.ModuleName
import dev.kord.x.commands.kord.model.context.KordCommandEvent
import dev.kord.x.commands.kord.module.command
import dev.kord.x.commands.model.command.invoke
import kotlinx.datetime.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@ModuleName("ping-command")
fun pingCommand() = command("ping") {
    suspend fun KordCommandEvent.calculatePing(): Pair<Message, Long> {
        val message = respond("${author.mention} Calculando...")
        val ping = (message.timestamp - this.message.timestamp).inWholeMilliseconds
        return message to ping
    }
    invoke {
        val apiPing = kord.gateway.gateways.values.map { it.ping.value }.first()?.inWholeMilliseconds ?: Long.MAX_VALUE
        val (message, ping) = calculatePing()
        val user = author
        message.edit {
            content = author.mention
            embed {
                color = Color((Math.random() * 0x1000000).toInt())
                title = "\uD83C\uDFD3 Latência"
                field("Discord API") {
                    "<a:discordblob:856988891776417852> **API** » $apiPing ms"
                }
                field("Implementação") {
                    "\uD83D\uDD38 **Ping** » $ping ms"
                }
                footer {
                    text = "Executado por ${user.tag}"
                    icon = user.avatar.url
                }
                timestamp = Clock.System.now()
            }
        }
    }
}


@ModuleName("pig-command")
fun pigCommand() = command("pig") {
    alias(":pig:", "\uD83D\uDC37")
    invoke {
        respond("Pog! <:pog:856141928029356036>")
    }
}