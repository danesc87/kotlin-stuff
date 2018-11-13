package com.nanobytes.springboot.crud

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Main class of the SprginBoot CRUD application
 * @author Daniel Córdova A.
 */
@SpringBootApplication
object Application {
    private val LOGGER: Logger = LoggerFactory.getLogger(Application.javaClass)

    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(Application.javaClass, *args)
        LOGGER.info("Application Started!\n")
    }
}
