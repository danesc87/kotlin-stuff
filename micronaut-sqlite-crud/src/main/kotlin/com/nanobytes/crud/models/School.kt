package com.nanobytes.crud.models

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.NotNull
import ninja.sakib.pultusorm.annotations.PrimaryKey

/**
 * Model for School object
 */
class School {

    @PrimaryKey
    @AutoIncrement
    var id: Int = 0
    @NotNull
    lateinit var schoolName: String
}
