package com.nanobytes.crud

import io.micronaut.runtime.Micronaut

/**
 * Main class of the Micronaut CRUD application
 */
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application::class.java, *args)
    }
}