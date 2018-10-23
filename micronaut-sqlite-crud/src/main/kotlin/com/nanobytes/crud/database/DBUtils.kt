package com.nanobytes.crud.database

import io.micronaut.context.annotation.Property
import io.micronaut.context.annotation.Value
import io.micronaut.core.annotation.Internal
import ninja.sakib.pultusorm.core.PultusORM

/**
 * Singleton that has some DataBase stuff
 */
@Internal
object DBUtils {

    @Property(name = "belle.name")
    private var dbName: String = ""

    @Value("\${belle.path}")
    private var dbPath: String = ""

    var pultusORM: PultusORM? = null

    fun initOrCreateDB() {
        pultusORM = PultusORM(getDBName(), getDBPath())
    }

    private fun getDBName(): String {
        if (dbName.isNullOrEmpty()) {
            return "mscDB.db"
        } else {
            return dbName
        }
    }

    private fun getDBPath(): String {
        if (dbPath.isNullOrEmpty() || dbPath.equals("/")){
            return System.getProperty("user.dir")
        } else {
            return dbPath
        }
    }
}