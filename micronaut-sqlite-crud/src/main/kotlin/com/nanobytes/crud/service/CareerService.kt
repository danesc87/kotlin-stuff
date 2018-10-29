package com.nanobytes.crud.service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Career
import ninja.sakib.pultusorm.core.PultusORM

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
}