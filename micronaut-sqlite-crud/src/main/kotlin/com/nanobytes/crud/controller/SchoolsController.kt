package com.nanobytes.crud.controller

import com.nanobytes.crud.models.School
import com.nanobytes.crud.service.SchoolService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.reactivex.Single

/**
 * Controller for schools endpoints
 * @author Daniel Córdova A.
 */
@Controller("\${micronaut.server.context-path}/school")
class SchoolsController {

    @Post("/")
    fun postSchool(@Body school: School): Single<School> {
        SchoolService.saveNewPerson(school)
        return Single.just(school)
    }

    @Get("/")
    fun getAllSchools() {

    }

    @Get("/{id}")
    fun getSchoolById() {

    }
}