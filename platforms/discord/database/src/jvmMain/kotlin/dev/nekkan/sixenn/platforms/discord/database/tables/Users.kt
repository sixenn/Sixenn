package dev.nekkan.sixenn.platforms.discord.database.tables

import dev.nekkan.sixenn.locale.Language
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.`java-time`.datetime

object Users : LongIdTable("users") {

    val galaxies = long("galaxies")
        .default(0L)

    val language = enumeration("language", Language::class)
        .default(Language.Portuguese_BR)

    val lastDailyDatetime = datetime("last_daily_datetime")

}