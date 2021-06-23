package dev.nekkan.sixenn.common.utils.files

import java.io.File

actual inline val home: String
    get() = System.getProperty("user.home")

actual inline fun readFile(path: String): String = File(path.replace("/", File.separator)).readText()
