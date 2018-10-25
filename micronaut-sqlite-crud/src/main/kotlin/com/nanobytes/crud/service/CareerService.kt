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
}