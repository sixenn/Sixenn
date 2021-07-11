package dev.nekkan.sixenn.platforms.discord.gateway.script

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

@JvmInline
value class ScriptParser(
    val engine: ScriptEngine = ScriptEngineManager(Thread.currentThread().contextClassLoader).getEngineByExtension("kts")
) {

    fun parse(header: ScriptHeader, code: String): Any? =
        runCatching {
            engine.eval(
                """
            ${header.imports.joinToString("\n", transform = { "import ${it.value}" })}
            ${code.removePrefix("```").removePrefix("```kotlin").removeSuffix("```")}
        """
            )
        }.getOrElse { "An exception has been thrown. '${it.message}'" }


}

val scriptParser by lazy { ScriptParser() }
