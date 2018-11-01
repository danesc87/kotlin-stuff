package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Student
import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.PultusORMCondition
import ninja.sakib.pultusorm.core.PultusORMUpdater

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
            PersonService.getPersonById(student.personId)
            pultusORM.save(student)
        } catch (e: IndexOutOfBoundsException) {
            false
        }
    }

    fun getAllStudents(): MutableList<Student> {
        val dbResult: MutableList<Any> = pultusORM.find(Student())
        val studentList: MutableList<Student> = mutableListOf()
        dbResult.forEach { studentList.add(it as Student) }
        return studentList
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getStudentById(id: Int): Student {
        val studentIdCondition: PultusORMCondition = DBUtils.buildConditionById(id)
        return pultusORM
                .find(
                        Student(),
                        studentIdCondition
                )[0] as Student
    }

    fun fullUpdate(id: Int, student: Student): Boolean {
        val studenCondition: PultusORMCondition = DBUtils.buildConditionById(id)
        val studentUpdater: PultusORMUpdater = PultusORMUpdater
                .Builder()
                .set("schoolId", student.schoolId)
                .set("careerId", student.careerId)
                .set("personId", student.personId)
                .condition(studenCondition)
                .build()
        return pultusORM.update(Student(), studentUpdater)
    }
}