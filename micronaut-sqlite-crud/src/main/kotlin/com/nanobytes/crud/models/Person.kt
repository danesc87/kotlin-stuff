package com.nanobytes.crud.models

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.NotNull
import ninja.sakib.pultusorm.annotations.PrimaryKey
import ninja.sakib.pultusorm.annotations.Unique

/**
 * Model for Person object
 * @author Daniel Córdova A.
 */
class Person {

    @PrimaryKey
    @AutoIncrement
    var id: Int = 0
    @NotNull
    @Unique
    lateinit var dni: String
    @NotNull
    lateinit var name: String
    @NotNull
    lateinit var lastName: String

}
