package com.nanobytes.crud.database

import ninja.sakib.pultusorm.core.PultusORM

/**
 * Singleton that has some DataBase stuff
 */
object DBUtils {

    lateinit var pultusORM: PultusORM

    fun initOrCreate() {
        pultusORM = PultusORM(
                "mscDB.db",
                System.getProperty("user.dir")
        )
    }

}