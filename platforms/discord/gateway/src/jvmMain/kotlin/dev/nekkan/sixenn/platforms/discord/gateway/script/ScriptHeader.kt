package dev.nekkan.sixenn.platforms.discord.gateway.script

open class ScriptHeader(open val imports: List<ScriptImport>)

data class MutableScriptHeader(override val imports: MutableList<ScriptImport>) : ScriptHeader(imports)
