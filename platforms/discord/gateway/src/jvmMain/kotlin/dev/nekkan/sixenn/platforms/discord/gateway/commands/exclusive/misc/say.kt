@file:JvmName("SayCommand")
@file:AutoWired

package dev.nekkan.sixenn.platforms.discord.gateway.commands.exclusive.misc

import dev.kord.core.behavior.channel.createMessage
import dev.kord.rest.builder.message.AllowedMentionsBuilder
import dev.kord.x.commands.annotation.AutoWired
import dev.kord.x.commands.annotation.ModuleName
import dev.kord.x.commands.argument.text.StringArgument
import dev.kord.x.commands.kord.module.command
import dev.kord.x.commands.model.command.invoke
import dev.nekkan.sixenn.locale.get
import dev.nekkan.sixenn.platforms.discord.gateway.sixenn
import dev.nekkan.sixenn.platforms.discord.gateway.utils.locale

@ModuleName("say-command")
fun sayCommand() = command("say") {
    alias("falar")
    invoke(StringArgument) { text ->
        channel.createMessage {
            content =
                if (author.id.value != sixenn.configuration.discord.ownerId)
                    "*${author.locale["commands.misc.say.sent-by".replace("{0}", author.mention)]}*\n\n$text"
                else text
            allowedMentions = AllowedMentionsBuilder()
        }
    }
}