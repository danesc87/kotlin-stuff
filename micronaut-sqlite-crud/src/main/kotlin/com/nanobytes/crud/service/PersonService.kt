package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Person
import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.PultusORMCondition

/**
 * Class that has all functions for Person object
 * @author Daniel Córdova A.
 */
object PersonService {

    private val pultusORM: PultusORM = DBUtils.pultusORM

    fun saveNewPerson(person: Person): Boolean {
        return pultusORM.save(person)
    }

    fun getAllPersons(): MutableList<Person> {
        val dbResult: MutableList<Any> = pultusORM.find(Person())
        val personList: MutableList<Person> = mutableListOf()
        dbResult.forEach { personList.add(it as Person) }
        return personList
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getPersonById(id: Int): Person {
        val personIdCondition: PultusORMCondition = DBUtils.buildConditionById(id)
        return pultusORM
                .find(
                        Person(),
                        personIdCondition
                )[0] as Person
    }
}