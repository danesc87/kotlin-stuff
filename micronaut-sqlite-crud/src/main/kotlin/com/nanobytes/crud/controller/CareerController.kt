package com.nanobytes.crud.controller

import com.nanobytes.crud.models.Career
import com.nanobytes.crud.service.CareerService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

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
    fun getCareerById(id: Int): HttpResponse<Career> {
        return try {
            HttpResponse.ok(CareerService.getCareerById(id))
        } catch (e: IndexOutOfBoundsException) {
            HttpResponse.notFound()
        }
    }

    @Put("/{id}")
    fun putCarrer(
            id: Int,
            @Body career: Career
    ): HttpResponse<Career> {
        val updated: Boolean =  CareerService.fullUpdate(id, career)
        return if (updated) {
            HttpResponse.ok(career)
        } else {
            HttpResponse.badRequest()
        }
    }

    @Patch("/{id}")
    fun patchCareer(
            id: Int,
            @QueryValue parametersToUpdate: Any
    ): HttpResponse<Career> {
        val updated: Boolean = CareerService.partialUpdate(id, parametersToUpdate)
        return if (updated) {
            HttpResponse.ok(CareerService.getCareerById(id))
        } else {
            HttpResponse.badRequest()
        }
    }
}