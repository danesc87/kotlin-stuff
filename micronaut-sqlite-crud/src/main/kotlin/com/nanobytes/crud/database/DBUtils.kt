package com.nanobytes.crud.database

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectReader
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
            stringPartialBody: String,
            classType: Any
    ): Boolean {
        try {
            val jsonStringReader: ObjectReader = ObjectMapper().readerFor(Map::class.java)
            val partialBodyMap: Map<String, String> = jsonStringReader.readValue<Map<String, String>>(stringPartialBody)
            val objectCondition: PultusORMCondition = DBUtils.buildConditionById(id)
            val objectUpdater: PultusORMUpdater.Builder = PultusORMUpdater
                    .Builder()
            for (key: String in partialBodyMap.keys) {
                objectUpdater.set(key, partialBodyMap[key]!!)
            }
            return pultusORM.update(
                    classType,
                    objectUpdater.condition(objectCondition).build()
            )
        } catch (e: JsonParseException) {
            return false
        } catch (ex: PultusORMException) {
            return false
        }
    }
}
