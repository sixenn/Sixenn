@file:JvmName("PingCommand")
@file:AutoWired
package dev.nekkan.sixenn.platforms.discord.gateway.commands.exclusive.misc

import dev.kord.core.behavior.edit
import dev.kord.core.entity.Message
import dev.kord.core.entity.User
import dev.kord.rest.builder.message.MessageModifyBuilder
import dev.kord.x.commands.annotation.AutoWired
import dev.kord.x.commands.annotation.ModuleName
import dev.kord.x.commands.kord.model.context.KordCommandEvent
import dev.kord.x.commands.kord.module.command
import dev.kord.x.commands.model.command.invoke
import dev.kord.x.emoji.Emojis
import dev.nekkan.sixenn.locale.Language
import dev.nekkan.sixenn.locale.get
import dev.nekkan.sixenn.platforms.discord.common.utils.randomColor
import dev.nekkan.sixenn.platforms.discord.gateway.utils.locale
import kotlinx.datetime.Clock
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@ModuleName("ping-command")
fun pingCommand() = command("ping") {
    suspend fun KordCommandEvent.calculatePing(messages: Language): Pair<Message, Double> {
        val message = respond("${author.mention} ${messages["commands.misc.ping.calculating"]}")
        val ping = (message.timestamp - this.message.timestamp).toDouble(DurationUnit.MILLISECONDS)
        return message to ping
    }

    suspend fun MessageModifyBuilder.createEmbed(messages: Language, author: User, ping: Double, apiPing: Long) =
        embed {
            color = randomColor()
            title = "${Emojis.pingPong} ${messages["commands.misc.ping.latency"]}"
            field("Discord API") {
                "<a:discordblob:856988891776417852> **API** » $apiPing ms"
            }
            field(messages["commands.misc.ping.implementation"].toString()) {
                "${Emojis.smallOrangeDiamond} **Ping** » $ping ms"
            }
            footer {
                text = messages["embeds.executed-by"].toString().replace("{0}", author.tag)
                icon = author.avatar.url
            }
            timestamp = Clock.System.now()
        }

    invoke {
        val locale = author.locale
        val apiPing = kord.gateway.gateways.values.map { it.ping.value }.first()?.inWholeMilliseconds ?: Long.MAX_VALUE
        val (message, ping) = calculatePing(locale)
        message.edit {
            content = author.mention
            createEmbed(locale, author, ping, apiPing)
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