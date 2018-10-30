package com.nanobytes.crud.database

import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.PultusORMCondition

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
}