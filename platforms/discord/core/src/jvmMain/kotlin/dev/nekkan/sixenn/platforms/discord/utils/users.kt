@file:JvmName("Users")

package dev.nekkan.sixenn.platforms.discord.utils

import dev.kord.core.entity.User
import dev.nekkan.sixenn.locale.Language

// TODO: Locales per user
inline val User.locale
    get() = Language.Portuguese_BR
