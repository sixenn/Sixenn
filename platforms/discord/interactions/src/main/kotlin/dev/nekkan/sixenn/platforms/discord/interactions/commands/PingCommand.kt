package dev.nekkan.sixenn.platforms.discord.interactions.commands

import dev.kord.x.emoji.Emojis
import net.perfectdreams.discordinteraktions.common.commands.slash.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.context.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.context.commands.slash.SlashCommandArguments
import net.perfectdreams.discordinteraktions.declarations.commands.slash.SlashCommandExecutorDeclaration
import net.perfectdreams.discordinteraktions.declarations.commands.slash.slashCommand
import net.perfectdreams.discordinteraktions.declarations.commands.wrappers.SlashCommandDeclarationWrapper

object PingCommand : SlashCommandDeclarationWrapper {

    override fun declaration() = slashCommand(
        name = "ping",
        description = "${Emojis.pingPong} A command that will reply back with Pong!"
    ) {
        executor = PingExecutor
    }

}

class PingExecutor : SlashCommandExecutor() {

    companion object Declaration : SlashCommandExecutorDeclaration(PingExecutor::class)

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val message = context.sendMessage {
            content = "${Emojis.pingPong} Pong!"
        }
    }

}