package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils.buildConditionById
import com.nanobytes.crud.database.DBUtils.pultusORM
import com.nanobytes.crud.models.School
import ninja.sakib.pultusorm.core.PultusORMCondition
import ninja.sakib.pultusorm.core.PultusORMUpdater

/**
 * Singleton that has all functions for School object
 * @author Daniel Córdova A.
 */
object SchoolService {

    fun saveNewSchool(school: School): Boolean {
        return pultusORM.save(school)
    }

    fun getAllSchools(): MutableList<School> {
        val dbResult: MutableList<Any> = pultusORM.find(School())
        val schoolList: MutableList<School> = mutableListOf()
        dbResult.forEach { schoolList.add(it as School) }
        return schoolList
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getSchoolById(id: Int): School {
        val schoolCondition: PultusORMCondition = buildConditionById(id)
        return pultusORM
                .find(
                        School(),
                        schoolCondition
                )[0] as School
    }

    fun fullUpdate(id: Int, school: School): Boolean {
        val schoolCondition: PultusORMCondition = buildConditionById(id)
        val schoolUpdater: PultusORMUpdater = PultusORMUpdater
                .Builder()
                .set("schoolName", school.schoolName)
                .condition(schoolCondition)
                .build()
        return pultusORM.update(School(), schoolUpdater)
    }

    fun deleteSchool(id: Int): Boolean {
        val schoolCondition: PultusORMCondition = buildConditionById(id)
        return pultusORM.delete(School(), schoolCondition)
    }
}
