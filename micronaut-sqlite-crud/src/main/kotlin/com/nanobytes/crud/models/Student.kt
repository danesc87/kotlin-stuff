package com.nanobytes.crud.models

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.NotNull
import ninja.sakib.pultusorm.annotations.PrimaryKey
import ninja.sakib.pultusorm.annotations.Unique

/**
 * Model for Student object
 * @author Daniel Córdova A.
 */
class Student {

    @PrimaryKey
    @AutoIncrement
    var id: Int = 0
    @NotNull
    var schoolId: Int = 0
    @NotNull
    var careerId: Int = 0
    @NotNull
    @Unique
    var personId: Int = 0
}
