@file:JvmName("InteractionsBootstrap")

package dev.nekkan.sixenn.platforms.discord.interactions

import dev.kord.common.annotation.KordPreview
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.x.emoji.Emojis
import dev.nekkan.sixenn.config.DiscordConfig
import dev.nekkan.sixenn.platforms.discord.interactions.commands.PingCommand
import dev.nekkan.sixenn.platforms.discord.interactions.commands.PingExecutor
import net.perfectdreams.discordinteraktions.common.commands.CommandManager
import net.perfectdreams.discordinteraktions.platforms.kord.commands.KordCommandRegistry
import net.perfectdreams.discordinteraktions.platforms.kord.installDiscordInteraKTions

@OptIn(KordPreview::class)
suspend fun main() {
    val config = DiscordConfig()
    val discord = Kord(token = config.token)
    val applicationId = Snowflake(value = config.applicationId)

    val commandManager = CommandManager()
    commandManager.register(PingCommand, PingExecutor())

    val registry = KordCommandRegistry(
        applicationId = applicationId,
        rest = discord.rest,
        manager = commandManager
    )

    println("[!] Refreshing all commands in testing guild...")
    registry.updateAllCommandsInGuild(Snowflake(value = config.testingServerId), true)
    println("[${Emojis.heavyCheckMark}] Successfully refreshed all commands.")

    //println("[!] Refreshing all commands globally.")
    //registry.updateAllGlobalCommands(true)
    //println("[${Emojis.heavyCheckMark}] Successfully refreshed all commands.")

    discord.gateway.gateways.forEach {
        it.value.installDiscordInteraKTions(applicationId, discord.rest, commandManager)
    }

    discord.login()
}
