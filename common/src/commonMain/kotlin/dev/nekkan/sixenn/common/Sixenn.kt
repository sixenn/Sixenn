package dev.nekkan.sixenn.common

import dev.nekkan.sixenn.common.configuration.BaseSixennConfiguration
import dev.nekkan.sixenn.common.services.BaseSixennServices
import mu.KotlinLogging

interface Sixenn<C : BaseSixennConfiguration<*, *>, S : BaseSixennServices> {

    companion object {
        val Logger = KotlinLogging.logger {}
    }

    val configuration: C

    val services: S

}