package com.nanobytes.crud.controller

import com.nanobytes.crud.models.Person
import com.nanobytes.crud.service.PersonService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

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
    fun getAllPersons(): HttpResponse<MutableList<Person>> {
        return HttpResponse.ok(PersonService.getAllPersons())
    }

    @Get("/{id}")
    fun getPersonById(id: Int): HttpResponse<Person> {
        return try {
            HttpResponse.ok(PersonService.getPersonById(id))
        } catch (e: IndexOutOfBoundsException) {
            HttpResponse.notFound()
        }
    }

    @Put("/{id}")
    fun putPerson(
            id: Int,
            @Body person: Person
    ): HttpResponse<Person> {
        val updated: Boolean = PersonService.fullUpdate(id, person)
        return if (updated) {
            HttpResponse.ok(person)
        } else {
            HttpResponse.badRequest()
        }
    }

    @Patch("/{id}")
    fun patchPerson(
            id: Int,
            @QueryValue parametersToUpdate: Any
    ): HttpResponse<Person> {
        val updated: Boolean = PersonService.partialUpdate(id, parametersToUpdate)
        return if (updated) {
            HttpResponse.ok(PersonService.getPersonById(id))
        } else {
            return HttpResponse.badRequest()
        }
    }

    @Delete("/{id}")
    fun deletePerson(id: Int): HttpResponse<Person> {
        val deleted: Boolean = PersonService.deletePerson(id)
        return if (deleted) {
            HttpResponse.ok()
        } else {
            HttpResponse.badRequest()
        }
    }
}
