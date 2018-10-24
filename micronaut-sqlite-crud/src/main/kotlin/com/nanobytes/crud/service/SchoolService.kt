package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.School
import ninja.sakib.pultusorm.core.PultusORM

/**
 * Singleton that has all functions for School object
 */
object SchoolService {

    private val pultusORM: PultusORM = DBUtils.pultusORM

    fun saveNewSchool(school: School): Boolean {
        return pultusORM.save(school)
    }

    fun getAllSchools(): MutableList<School> {
        val dbResult: MutableList<Any> = pultusORM.find(School())
        val schoolList: MutableList<School> = mutableListOf()
        dbResult.forEach { schoolList.add(it as School) }
        return schoolList
    }
}