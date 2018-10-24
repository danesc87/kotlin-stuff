package com.nanobytes.crud.models

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.NotNull
import ninja.sakib.pultusorm.annotations.PrimaryKey
import ninja.sakib.pultusorm.annotations.Unique

/**
 * Model for Career object
 */
class Career {

    @PrimaryKey
    @AutoIncrement
    var id: Int = 0
    var schoolId: Int = 0
    @NotNull
    @Unique
    lateinit var career: String
}
