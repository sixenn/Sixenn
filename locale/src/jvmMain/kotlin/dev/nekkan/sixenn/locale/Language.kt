package dev.nekkan.sixenn.locale

import dev.nekkan.sixenn.common.utils.files.home
import dev.nekkan.sixenn.common.utils.files.readFile
import org.yaml.snakeyaml.Yaml

private inline fun Language.file(name: String) = readFile("$home/sixenn/translations/$code/$name")

actual enum class Language(val code: String) {

    Portuguese_BR("pt_BR"),
    English_US("en_US");

    @OptIn(ExperimentalStdlibApi::class)
    actual val translations: Map<String, Any> = buildMap {
        putAll(Yaml().load(file("commands.yml")))
        putAll(Yaml().load(file("embeds.yml")))
    }

}

inline operator fun Language.get(path: String): String {
    val dots = path.split('.')
    var value: Any? = translations
    for (dot in dots) {
        value = (value as? Map<String, Any>?)?.get(dot) ?: value
    }
    return "$value"
}
