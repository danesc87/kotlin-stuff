package com.nanobytes.springboot.crud

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Main class of the SprginBoot CRUD application
 * @author Daniel Córdova A.
 */
@SpringBootApplication
class Application

    private val LOGGER: Logger = LoggerFactory.getLogger(Application::class.java)

    fun main(args: Array<String>) {
        runApplication<Application>(*args)
        LOGGER.info("Application Started!\n")
    }
