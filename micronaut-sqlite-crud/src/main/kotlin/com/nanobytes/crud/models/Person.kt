package com.nanobytes.crud.models

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.NotNull
import ninja.sakib.pultusorm.annotations.PrimaryKey

/**
 * Model for Person object
 */
class Person {

    @PrimaryKey
    @AutoIncrement
    var id: Int = 0
    @NotNull
    lateinit var dni: String
    @NotNull
    lateinit var name: String
    @NotNull
    lateinit var lastName: String

}
