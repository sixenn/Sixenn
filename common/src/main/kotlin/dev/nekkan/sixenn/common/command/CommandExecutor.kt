package dev.nekkan.sixenn.common.command

import dev.nekkan.sixenn.common.Sixenn

interface CommandExecutor<T : Sixenn<*, *>, C : BaseCommandContext<*, *>> {

    suspend fun execute(platform: T, context: C)

}