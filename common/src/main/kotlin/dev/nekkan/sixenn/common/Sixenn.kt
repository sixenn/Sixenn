package dev.nekkan.sixenn.common

import dev.nekkan.sixenn.common.configuration.BaseSixennConfiguration
import dev.nekkan.sixenn.common.services.BaseSixennServices

interface Sixenn<C : BaseSixennConfiguration<*, *>, S : BaseSixennServices> {

    val configuration: C

    val services: S

}