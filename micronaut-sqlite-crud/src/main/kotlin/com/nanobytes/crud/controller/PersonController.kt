package com.nanobytes.crud.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

/**
 * Controller for person endpoints
 * @author Daniel Córdova A.
 */
@Controller("/person")
class PersonController {

    @Post("/")
    fun postPerson() {

    }

    @Get("/")
    fun getAllPersons() {

    }

    @Get("/{id}")
    fun getPersonById() {

    }
}