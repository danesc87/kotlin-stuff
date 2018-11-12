package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Career
import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.PultusORMCondition
import ninja.sakib.pultusorm.core.PultusORMUpdater

/**
 * Class that has all functions for Career object
 * @author Daniel Córdova A.
 */
object CareerService {

    private val pultusORM: PultusORM = DBUtils.pultusORM

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
        val careerCondition: PultusORMCondition = DBUtils.buildConditionById(id)
        return pultusORM
                .find(
                        Career(),
                        careerCondition
                )[0] as Career
    }

    fun fullUpdate(id: Int, career: Career): Boolean {
        val careerCondition: PultusORMCondition = DBUtils.buildConditionById(id)
        val careerUpdater: PultusORMUpdater = PultusORMUpdater
                .Builder()
                .set("schoolId", career.schoolId)
                .set("career", career.career)
                .condition(careerCondition)
                .build()
        return pultusORM.update(Career(), careerUpdater)
    }

    fun partialUpdate(id: Int, parametersToUpdate: Map<String, String>): Boolean {
        val careerCondition: PultusORMCondition = DBUtils.buildConditionById(id)
        val careerUpdater: PultusORMUpdater.Builder = PultusORMUpdater
                .Builder()
        for (key: String in parametersToUpdate.keys) {
            careerUpdater.set(key, parametersToUpdate[key]!!)
        }
        careerUpdater.condition(careerCondition).build()
        return pultusORM.update(
                Career(),
                careerUpdater.condition(careerCondition).build()
        )
    }
}