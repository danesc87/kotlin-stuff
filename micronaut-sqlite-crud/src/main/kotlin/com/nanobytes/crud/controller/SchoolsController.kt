package com.nanobytes.crud.controller

import com.nanobytes.crud.models.School
import com.nanobytes.crud.service.SchoolService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
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
    fun postSchool(@Body school: School): HttpResponse<School> {
        val saved: Boolean = SchoolService.saveNewSchool(school)
        return if (saved) {
            HttpResponse.created(school)
        } else {
            HttpResponse.badRequest()
        }
    }

    @Get("/")
    fun getAllSchools(): MutableList<School> {
        return SchoolService.getAllSchools()
    }

    @Get("/{id}")
    fun getSchoolById(id: Int): HttpResponse<School> {
        return try {
            HttpResponse.ok(SchoolService.getSchoolById(id))
        } catch (e: IndexOutOfBoundsException) {
            HttpResponse.notFound()
        }
    }
}