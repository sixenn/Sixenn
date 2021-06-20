@file:AutoWired

package dev.nekkan.sixenn.platforms.discord

import com.typesafe.config.ConfigFactory
import dev.kord.x.commands.annotation.AutoWired
import dev.kord.x.commands.kord.bot
import dev.kord.x.commands.kord.model.prefix.mention
import dev.kord.x.commands.model.context.CommonContext
import dev.kord.x.commands.model.prefix.literal
import dev.kord.x.commands.model.prefix.or
import dev.nekkan.sixenn.common.Sixenn
import dev.nekkan.sixenn.platforms.discord.services.EmptyServices
import io.github.config4k.extract
import kapt.kotlin.generated.configure

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
object SixennDiscord : Sixenn<DiscordSixennConfiguration, EmptyServices> {

    override val configuration =
        ConfigFactory.parseString(DiscordSixennConfiguration::class.java.getResource("/sixenn.conf").readText())
            .extract<DiscordSixennConfiguration>()

    override val services: EmptyServices
        get() = EmptyServices

}

inline val sixenn: SixennDiscord get() = SixennDiscord

suspend fun main() = bot(sixenn.configuration.sixenn.discord.token) {
    prefix {
        add(CommonContext) {
            literal(sixenn.configuration.defaultPrefix) or mention()
        }
    }
    configure()
}
