package dev.nekkan.sixenn.common.builders

open class BaseStyledResponseBuilder(
    var content: String? = null,
    var fields: MutableList<Field>? = null,
    var description: String? = null,
    var title: String? = null,
    var footer: Footer? = null
) {

    data class Footer(val text: String, val iconUrl: String)

    data class Field(val name: String, val value: String, val inline: Boolean = false)

    fun field(name: String, value: String, inline: Boolean = false) {
        if (fields == null) {
            fields = mutableListOf()
        }
        fields!!.add(Field(name, value, inline))
    }

}

inline fun styledResponse(builder: BaseStyledResponseBuilder.() -> Unit) =
    BaseStyledResponseBuilder().apply(builder)
