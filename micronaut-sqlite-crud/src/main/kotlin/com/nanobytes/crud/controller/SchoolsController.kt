package com.nanobytes.crud.controller

import com.nanobytes.crud.models.School
import com.nanobytes.crud.service.SchoolService
import io.micronaut.http.HttpResponse
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
    fun postSchool(@Body school: School): Single<HttpResponse<School>> {
        val saved: Boolean = SchoolService.saveNewSchool(school)

        if (saved) {
            return Single.just(HttpResponse.created(school))
        } else {
            return Single.just(HttpResponse.ok())
        }
    }

    @Get("/")
    fun getAllSchools(): Single<MutableList<School>> {
        return Single.just(SchoolService.getAllSchools())
    }

    @Get("/{id}")
    fun getSchoolById() {

    }
}