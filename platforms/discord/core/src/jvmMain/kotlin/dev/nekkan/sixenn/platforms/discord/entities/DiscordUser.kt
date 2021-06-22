package dev.nekkan.sixenn.platforms.discord.entities

import dev.nekkan.sixenn.common.entities.User
import dev.nekkan.sixenn.platforms.discord.config.DiscordSixennIdentification

typealias DiscordUser = User<DiscordSixennIdentification, dev.kord.core.entity.User>
