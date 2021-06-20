@file:AutoWired

package dev.nekkan.sixenn.platforms.discord

import com.typesafe.config.ConfigFactory
import dev.kord.x.commands.annotation.AutoWired
import dev.kord.x.commands.kord.bot
import dev.kord.x.commands.kord.model.prefix.mention
import dev.kord.x.commands.model.context.CommonContext
import dev.kord.x.commands.model.prefix.literal
import dev.kord.x.commands.model.prefix.or
import io.github.config4k.extract
import kapt.kotlin.generated.configure

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
internal val sixennConfig = ConfigFactory.parseString(SixennConfig::class.java.getResource("/sixenn.conf").readText())
    .extract<SixennConfig>()

suspend fun main() = bot(sixennConfig.sixenn.discord.token) {
    prefix {
        add(CommonContext) {
            literal(sixennConfig.sixenn.defaultPrefix) or mention()
        }
    }
    configure()
}
