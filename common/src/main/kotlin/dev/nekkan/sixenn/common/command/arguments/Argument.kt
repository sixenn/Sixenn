package dev.nekkan.sixenn.common.command.arguments

sealed class Argument<T : Any> {

    abstract val value: T

    data class Text(override val value: String) : Argument<String>()

    data class Integer(override val value: Int) : Argument<Int>()

    data class User<T : dev.nekkan.sixenn.common.entities.User<*, *>>(
        override val value: dev.nekkan.sixenn.common.entities.User<*, *>
    ) : Argument<dev.nekkan.sixenn.common.entities.User<*, *>>()

}