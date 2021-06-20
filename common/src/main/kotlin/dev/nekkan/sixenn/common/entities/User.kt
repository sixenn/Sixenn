package dev.nekkan.sixenn.common.entities

import dev.nekkan.sixenn.common.configuration.BaseSixennIdentification

data class User<I : BaseSixennIdentification<*>, T>(
    val identification: I,
    val platformUser: T
)