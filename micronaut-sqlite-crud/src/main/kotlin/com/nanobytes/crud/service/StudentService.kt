package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Student
import ninja.sakib.pultusorm.core.PultusORM

/**
 * Class that has all functions for Student object
 * @author Daniel Córdova A.
 */
object StudentService {

    private val pultusORM: PultusORM = DBUtils.pultusORM

    fun saveNewStudent(student: Student): Boolean {
        return try {
            SchoolService.getSchoolById(student.schoolId)
            CareerService.getCareerById(student.careerId)
            PersonService.getPersonById(student.careerId)
            pultusORM.save(student)
        } catch (e: IndexOutOfBoundsException) {
            false
        }
    }
}