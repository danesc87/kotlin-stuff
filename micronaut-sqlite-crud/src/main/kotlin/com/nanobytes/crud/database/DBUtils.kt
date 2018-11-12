package com.nanobytes.crud.database

import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.PultusORMCondition
import ninja.sakib.pultusorm.core.PultusORMUpdater
import ninja.sakib.pultusorm.exceptions.PultusORMException

/**
 * Singleton that has some DataBase stuff
 * @author Daniel Córdova A.
 */
object DBUtils {

    lateinit var pultusORM: PultusORM

    private const val dbName: String = "mscDB.db"
    private val dbPath: String = System.getProperty("user.dir")

    fun initOrCreate() {
        initOrCreate(dbName, dbPath)
    }

    fun initOrCreate(dbName: String, dbPath: String) {
        pultusORM = PultusORM(dbName, dbPath)
    }

    fun buildConditionById(id: Int): PultusORMCondition {
        return PultusORMCondition
                .Builder()
                .eq("id", id)
                .build()
    }

    fun genericPartialUpdate(
            id: Int,
            parametersToUpdate: Any,
            classType: Any
    ): Boolean {
        try {
            val listOfParameters: MutableList<String> = mutableListOf()
            (parametersToUpdate as Iterable<String>)
                    .forEach { listOfParameters.addAll(
                            it.split(","))
                    }
            val parametersMap: MutableMap<String, String> = mutableMapOf()
            listOfParameters.forEach {
                val parameter: List<String> = it.split(":")
                parametersMap[parameter[0]] = parameter[1]
            }
            val careerCondition: PultusORMCondition = DBUtils.buildConditionById(id)
            val careerUpdater: PultusORMUpdater.Builder = PultusORMUpdater
                    .Builder()
            for (key: String in parametersMap.keys) {
                careerUpdater.set(key, parametersMap[key]!!)
            }
            careerUpdater.condition(careerCondition).build()
            return pultusORM.update(
                    classType,
                    careerUpdater.condition(careerCondition).build()
            )
        } catch (e: ClassCastException) {
            return false
        } catch (ex: PultusORMException) {
            return false
        }
    }
}
