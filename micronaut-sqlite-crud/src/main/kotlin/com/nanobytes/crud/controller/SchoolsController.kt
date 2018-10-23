package com.nanobytes.crud.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

/**
 * Controller for schools endpoints
 * @author Daniel Córdova A.
 */
@Controller("\${micronaut.server.context-path}/school")
class SchoolsController {

    @Post("/")
    fun postSchool() {

    }

    @Get("/")
    fun getAllSchools() {

    }

    @Get("/{id}")
    fun getSchoolById() {

    }
}