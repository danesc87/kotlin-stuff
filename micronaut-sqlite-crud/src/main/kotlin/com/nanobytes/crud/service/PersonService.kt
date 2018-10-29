package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Person
import ninja.sakib.pultusorm.core.PultusORM

/**
 * Class that has all functions for Person object
 * @author Daniel Córdova A.
 */
object PersonService {

    private val pultusORM: PultusORM = DBUtils.pultusORM

    fun saveNewPerson(person: Person): Boolean {
        return pultusORM.save(person)
    }
}