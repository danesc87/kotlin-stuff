package com.nanobytes.crud.controller

import com.nanobytes.crud.models.Career
import com.nanobytes.crud.service.CareerService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

/**
 * Controller for career endpoints
 * @author Daniel Córdova A.
 */
@Controller("\${micronaut.server.context-path}/career")
class CareerController {

    @Post("/")
    fun postCareer(@Body career: Career): HttpResponse<Career> {
        val saved: Boolean = CareerService.saveNewCareer(career)
        return if (saved) {
            HttpResponse.created(career)
        } else {
            HttpResponse.badRequest()
        }
    }

    @Get("/")
    fun getAllCareers(): HttpResponse<MutableList<Career>> {
        return HttpResponse.ok(CareerService.getAllCareers())
    }

    @Get("/{id}")
    fun getCareerById(id: Int) {

    }
}