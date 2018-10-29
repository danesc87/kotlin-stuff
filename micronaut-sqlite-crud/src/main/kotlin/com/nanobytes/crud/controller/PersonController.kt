package com.nanobytes.crud.controller

import com.nanobytes.crud.models.Person
import com.nanobytes.crud.service.PersonService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

/**
 * Controller for person endpoints
 * @author Daniel Córdova A.
 */
@Controller("\${micronaut.server.context-path}/person")
class PersonController {

    @Post("/")
    fun postPerson(@Body person: Person): HttpResponse<Person> {
        val saved: Boolean = PersonService.saveNewPerson(person)
        return if (saved) {
            HttpResponse.created(person)
        } else {
            HttpResponse.badRequest()
        }
    }

    @Get("/")
    fun getAllPersons() {

    }

    @Get("/{id}")
    fun getPersonById(id: Int) {

    }
}