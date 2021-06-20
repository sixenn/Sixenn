@file:JvmName("SayCommand")
@file:AutoWired

package dev.nekkan.sixenn.platforms.discord.commands.misc

import dev.kord.core.behavior.channel.createMessage
import dev.kord.rest.builder.message.AllowedMentionsBuilder
import dev.kord.x.commands.annotation.AutoWired
import dev.kord.x.commands.annotation.ModuleName
import dev.kord.x.commands.argument.text.StringArgument
import dev.kord.x.commands.kord.module.command
import dev.kord.x.commands.model.command.invoke
import dev.nekkan.sixenn.platforms.discord.sixennConfig

@ModuleName("say-command")
fun sayCommand() = command("say") {
    alias("falar")
    invoke(StringArgument) { text ->
        message.delete()
        channel.createMessage {
            content =
                if (author.id.value != sixennConfig.sixenn.ownerId) "*Enviado por ${author.mention}*\n\n$text" else text
            allowedMentions = AllowedMentionsBuilder()
        }
    }
}