package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils.buildConditionById
import com.nanobytes.crud.database.DBUtils.genericPartialUpdate
import com.nanobytes.crud.database.DBUtils.pultusORM
import com.nanobytes.crud.models.Person
import ninja.sakib.pultusorm.core.PultusORMCondition
import ninja.sakib.pultusorm.core.PultusORMUpdater

/**
 * Class that has all functions for Person object
 * @author Daniel Córdova A.
 */
object PersonService {

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
        val personIdCondition: PultusORMCondition = buildConditionById(id)
        return pultusORM
                .find(
                        Person(),
                        personIdCondition
                )[0] as Person
    }

    fun fullUpdate(id: Int, person: Person): Boolean {
        val personCondition: PultusORMCondition = buildConditionById(id)
        val personUpdater: PultusORMUpdater = PultusORMUpdater
                .Builder()
                .set("dni", person.dni)
                .set("name", person.name)
                .set("lastName", person.lastName)
                .condition(personCondition)
                .build()
        return pultusORM.update(Person(), personUpdater)
    }

    fun partialUpdate(id: Int, parametersToUpdate: Any): Boolean {
        return genericPartialUpdate(id, parametersToUpdate, Person())
    }
}