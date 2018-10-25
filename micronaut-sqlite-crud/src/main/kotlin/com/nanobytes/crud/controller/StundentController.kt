package com.nanobytes.crud.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

/**
 * Controller for student endpoints
 * @author Daniel Córdova A.
 */
@Controller("\${micronaut.server.context-path}/student")
class StundentController {

    @Post("/")
    fun postStudent() {

    }

    @Get("/")
    fun getAllStudents() {

    }

    @Get("/{id}")
    fun getStudentById(id: Int) {

    }
}