package dev.nekkan.sixenn.common.command

import dev.nekkan.sixenn.common.command.arguments.Argument
import dev.nekkan.sixenn.common.entities.Message
import dev.nekkan.sixenn.common.entities.User

interface BaseCommandContext<U : User<*, *>, E : Message<*, *>> {

    val author: U

    val message: E

    val arguments: List<Argument<*>>

}


inline fun <reified T : Argument<*>> BaseCommandContext<*, *>.getArgumentOrNull(position: Int): T? {
    return arguments.getOrNull(position - 1) as? T?
}

inline fun <reified T : Argument<*>> BaseCommandContext<*, *>.getArgument(position: Int): T {
    return getArgumentOrNull(position) ?: error("Could not get the argument at index ${position - 1}.")
}
