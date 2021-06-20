package dev.nekkan.sixenn.common.configuration

interface BaseSixennConfiguration<
        I : BaseSixennIdentification<out Any>,
        A : BaseSixennAuthenticator
        > {

    val defaultPrefix: String

    val ownerIdentification: I

    val authenticator: A

}