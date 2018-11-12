package com.nanobytes.crud.controller

import com.nanobytes.crud.models.Student
import com.nanobytes.crud.service.StudentService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

/**
 * Controller for student endpoints
 * @author Daniel Córdova A.
 */
@Controller("\${micronaut.server.context-path}/student")
class StundentController {

    @Post("/")
    fun postStudent(@Body student: Student): HttpResponse<Student> {
        val saved: Boolean = StudentService.saveNewStudent(student)
        return if (saved) {
            HttpResponse.created(student)
        } else {
            HttpResponse.badRequest()
        }
    }

    @Get("/")
    fun getAllStudents(): HttpResponse<MutableList<Student>> {
        return HttpResponse.ok(StudentService.getAllStudents())
    }

    @Get("/{id}")
    fun getStudentById(id: Int): HttpResponse<Student> {
        return try {
            HttpResponse.ok(StudentService.getStudentById(id))
        } catch (e: IndexOutOfBoundsException) {
            HttpResponse.notFound()
        }
    }

    @Put("/{id}")
    fun putStudent(
            id: Int,
            @Body student: Student
    ): HttpResponse<Student> {
        val updated: Boolean = StudentService.fullUpdate(id, student)
        return if (updated) {
            HttpResponse.ok(student)
        } else {
            HttpResponse.badRequest()
        }
    }

    @Patch("/{id}")
    fun patchStudent(
            id: Int,
            @QueryValue parametersToUpdate: Any
    ): HttpResponse<Student> {
        val updated: Boolean = StudentService.partialUpdate(id, parametersToUpdate)
        return if (updated) {
            HttpResponse.ok(StudentService.getStudentById(id))
        } else {
            HttpResponse.badRequest()
        }
    }
}
