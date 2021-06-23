package dev.nekkan.sixenn.platforms.discord.entities

import dev.kord.core.behavior.channel.createMessage
import dev.nekkan.sixenn.common.builders.BaseStyledResponseBuilder
import dev.nekkan.sixenn.common.entities.Message
import dev.nekkan.sixenn.platforms.discord.common.DiscordSixennIdentification
import dev.nekkan.sixenn.platforms.discord.utils.identification
import kotlinx.datetime.Instant

@JvmInline
value class DiscordMessage(override val platformExecution: dev.kord.core.entity.Message) :
    Message<DiscordSixennIdentification, dev.kord.core.entity.Message> {

    override val content: String
        get() = platformExecution.content

    override val creationDate: Instant
        get() = platformExecution.timestamp

    override val identification: DiscordSixennIdentification
        get() = platformExecution.id.identification

    override suspend fun respond(content: String): DiscordMessage {
        return DiscordMessage(platformExecution.channel.createMessage(content))
    }

    override suspend fun respondStyled(builder: BaseStyledResponseBuilder): DiscordMessage {
        return DiscordMessage(platformExecution.channel.createMessage {
            content = builder.content
            embed {
                builder.fields?.forEach { field(it.name, it.inline) { it.value } }
                description = builder.description
                builder.footer?.let {
                    footer {
                        text = it.text
                        icon = it.iconUrl
                    }
                }
                title = builder.title
            }
        })
    }

}

