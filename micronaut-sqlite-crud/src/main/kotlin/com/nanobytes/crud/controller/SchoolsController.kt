package com.nanobytes.crud.controller

import com.nanobytes.crud.models.School
import com.nanobytes.crud.service.SchoolService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

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

    @Put("/{id}")
    fun putSchool(
            id: Int,
            @Body school: School
    ): HttpResponse<School> {
        val updated:Boolean =  SchoolService.fullUpdate(id, school)
        return if (updated) {
            HttpResponse.ok(school)
        } else {
            HttpResponse.badRequest()
        }
    }

    @Delete("/{id}")
    fun deleteSchool(id: Int): HttpResponse<School> {
        val deleted: Boolean = SchoolService.deleteSchool(id)
        return if (deleted) {
            HttpResponse.ok()
        } else {
            HttpResponse.badRequest()
        }
    }
}
