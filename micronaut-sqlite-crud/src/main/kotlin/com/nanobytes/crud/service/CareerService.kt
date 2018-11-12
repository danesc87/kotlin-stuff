package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils.buildConditionById
import com.nanobytes.crud.database.DBUtils.genericPartialUpdate
import com.nanobytes.crud.database.DBUtils.pultusORM
import com.nanobytes.crud.models.Career
import ninja.sakib.pultusorm.core.PultusORMCondition
import ninja.sakib.pultusorm.core.PultusORMUpdater

/**
 * Class that has all functions for Career object
 * @author Daniel Córdova A.
 */
object CareerService {

    fun saveNewCareer(career: Career): Boolean {
        val schoolId: Int = career.schoolId
        return try {
            SchoolService.getSchoolById(schoolId)
            pultusORM.save(career)
        } catch (e: IndexOutOfBoundsException) {
            false
        }
    }

    fun getAllCareers(): MutableList<Career> {
        val dbResult: MutableList<Any> = pultusORM.find(Career())
        val careerList: MutableList<Career> = mutableListOf()
        dbResult.forEach { careerList.add(it as Career) }
        return careerList
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getCareerById(id: Int): Career {
        val careerCondition: PultusORMCondition = buildConditionById(id)
        return pultusORM
                .find(
                        Career(),
                        careerCondition
                )[0] as Career
    }

    fun fullUpdate(id: Int, career: Career): Boolean {
        val careerCondition: PultusORMCondition = buildConditionById(id)
        val careerUpdater: PultusORMUpdater = PultusORMUpdater
                .Builder()
                .set("schoolId", career.schoolId)
                .set("career", career.career)
                .condition(careerCondition)
                .build()
        return pultusORM.update(Career(), careerUpdater)
    }

    fun partialUpdate(id: Int, parametersToUpdate: Any): Boolean {
        return genericPartialUpdate(id, parametersToUpdate, Career())
    }
}
