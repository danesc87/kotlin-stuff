package com.nanobytes.crud

import io.micronaut.runtime.Micronaut

/**
 * Main class of the Micronaut CRUD application
 * @author Daniel Córdova A.
 */
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application::class.java, *args)
    }
}