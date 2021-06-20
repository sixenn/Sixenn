package dev.nekkan.sixenn.commands.miscellaneous

import dev.nekkan.sixenn.common.Sixenn
import dev.nekkan.sixenn.common.command.BaseCommandContext
import dev.nekkan.sixenn.common.command.CommandExecutor

class PingExecutor<T : Sixenn<*, *>, C : BaseCommandContext<*, *>> : CommandExecutor<T, C> {

    override suspend fun execute(platform: T, context: C) {
        context.message.respond("Pong!")
    }

}