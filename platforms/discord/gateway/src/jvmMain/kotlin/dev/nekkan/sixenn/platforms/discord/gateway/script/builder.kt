package dev.nekkan.sixenn.platforms.discord.gateway.script

@JvmInline
value class ScriptHeaderBuilder(val header: MutableScriptHeader)

inline fun ScriptHeaderBuilder.import(value: String) = header.imports.add(ScriptImport(value))

inline fun ScriptHeaderBuilder.importAll(value: String) = header.imports.add(ScriptImport("$value.*"))

inline fun ScriptHeaderBuilder.import(values: Collection<String>) =
    header.imports.addAll(values.map { ScriptImport(it) })

inline fun buildHeader(headerBuilder: ScriptHeaderBuilder.() -> Unit): ScriptHeader =
    ScriptHeaderBuilder(MutableScriptHeader(mutableListOf())).apply(headerBuilder).header
