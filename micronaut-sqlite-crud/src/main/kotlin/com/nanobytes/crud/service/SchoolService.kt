package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.School
import ninja.sakib.pultusorm.core.PultusORM

/**
 * Singleton that has all functions for School object
 */
object SchoolService {

    private val pultusORM: PultusORM = DBUtils.pultusORM

    fun saveNewPerson(school: School) {
        pultusORM.save(school)
    }
}