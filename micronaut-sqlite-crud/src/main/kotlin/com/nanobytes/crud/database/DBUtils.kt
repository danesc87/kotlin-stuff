package com.nanobytes.crud.database

import io.micronaut.core.annotation.Internal
import ninja.sakib.pultusorm.core.PultusORM

/**
 * Singleton that has some DataBase stuff
 */
@Internal
object DBUtils {

    var pultusORM: PultusORM? = null

    fun initOrCreateDB() {
        pultusORM = PultusORM(
                "mscDB.db",
                System.getProperty("user.dir")
        )
    }
}