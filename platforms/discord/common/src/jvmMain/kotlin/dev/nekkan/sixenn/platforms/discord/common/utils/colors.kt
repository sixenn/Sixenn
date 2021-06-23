@file:JvmName("Colors")

package dev.nekkan.sixenn.platforms.discord.common.utils

import dev.kord.common.Color

inline fun randomColor() = Color((Math.random() * 0x1000000).toInt())
