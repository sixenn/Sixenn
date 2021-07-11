@file:JvmName("EvalCommand")
@file:AutoWired

package dev.nekkan.sixenn.platforms.discord.gateway.commands.exclusive.misc

import dev.kord.x.commands.annotation.AutoWired
import dev.kord.x.commands.annotation.ModuleName
import dev.kord.x.commands.argument.text.StringArgument
import dev.kord.x.commands.kord.module.command
import dev.kord.x.commands.model.command.invoke
import dev.nekkan.sixenn.platforms.discord.gateway.script.buildHeader
import dev.nekkan.sixenn.platforms.discord.gateway.script.importAll
import dev.nekkan.sixenn.platforms.discord.gateway.script.scriptParser
import dev.nekkan.sixenn.platforms.discord.gateway.sixenn

private val header = buildHeader {
    importAll("dev.nekkan.sixenn.common")
    importAll("dev.nekkan.sixenn.platforms.discord")
    importAll("dev.nekkan.sixenn.platforms.discord.common")
    importAll("dev.nekkan.sixenn.platforms.discord.gateway")
    importAll("dev.nekkan.sixenn.platforms.discord.gateway.script")
    importAll("dev.nekkan.sixenn.platforms.discord.gateway.utils")
    importAll("dev.nekkan.sixenn.platforms.discord.common.context")
    importAll("dev.nekkan.sixenn.platforms.discord.common.entities")
    importAll("dev.nekkan.sixenn.platforms.discord.common.services")
    importAll("dev.nekkan.sixenn.platforms.discord.common.utils")
    importAll("dev.nekkan.sixenn.common.builders")
    importAll("dev.nekkan.sixenn.common.command")
    importAll("dev.nekkan.sixenn.common.configuration")
    importAll("dev.nekkan.sixenn.common.entities")
    importAll("dev.nekkan.sixenn.common.services")
    importAll("dev.nekkan.sixenn.common.utils")
    importAll("dev.kord.common")
    importAll("dev.kord.core")
    importAll("dev.kord.gateway")
    importAll("dev.kord.rest")
    importAll("dev.kord.common.entity")
    importAll("dev.kord.core.behavior")
    importAll("dev.kord.core.builder")
    importAll("dev.kord.core.cache")
    importAll("dev.kord.core.event")
    importAll("dev.kord.core.entity")
    importAll("dev.kord.core.exception")
    importAll("dev.kord.core.live")
    importAll("dev.kord.core.supplier")
    importAll("dev.kord.core.gateway")
    importAll("dev.kord.gateway.builder")
    importAll("dev.kord.rest.builder")
    importAll("dev.kord.rest.json")
    importAll("dev.kord.rest.request")
    importAll("dev.kord.rest.ratelimit")
    importAll("dev.kord.rest.route")
    importAll("dev.kord.rest.service")
}

@ModuleName("eval-command")
fun evalCommand() = command("eval") {
    invoke(StringArgument) { code ->
        if (author.id.value != sixenn.configuration.discord.ownerId) {
            error("You do not have permission to execute this command.")
        }
        respond(scriptParser.parse(header, code).toString())
    }
}