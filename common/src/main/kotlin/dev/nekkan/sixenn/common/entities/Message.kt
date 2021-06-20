package dev.nekkan.sixenn.common.entities

import dev.nekkan.sixenn.common.builders.BaseStyledResponseBuilder
import dev.nekkan.sixenn.common.configuration.BaseSixennIdentification
import kotlinx.datetime.Instant

interface Message<I : BaseSixennIdentification<*>, T> {

    val identification: I

    val platformExecution: T

    val content: String

    val creationDate: Instant

    suspend fun respond(content: String): Message<I, T>

    suspend fun respondStyled(content: BaseStyledResponseBuilder): Message<I, T>

}