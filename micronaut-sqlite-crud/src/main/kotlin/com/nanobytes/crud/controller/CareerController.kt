package com.nanobytes.crud.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

/**
 * Controller for career endpoints
 * @author Daniel Córdova A.
 */
@Controller("/career")
class CareerController {

    @Post("/")
    fun postCareer() {

    }

    @Get("/")
    fun getAllCareers() {

    }

    @Get("/{id}")
    fun getCareerById() {

    }
}