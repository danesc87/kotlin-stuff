package com.nanobytes.springboot.crud.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Type(
        @NotBlank
        val typeName: String,
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0
) {
    private constructor(): this ("")
}