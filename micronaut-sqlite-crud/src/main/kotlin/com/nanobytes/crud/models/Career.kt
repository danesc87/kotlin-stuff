package com.nanobytes.crud.models

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.NotNull
import ninja.sakib.pultusorm.annotations.PrimaryKey

/**
 * Model for Career object
 */
class Career {

    @PrimaryKey
    @AutoIncrement
    var id: Int = 0
    var schoolId: Int = 0
    @NotNull
    lateinit var career: String
}
