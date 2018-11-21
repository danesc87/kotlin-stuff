package com.nanobytes.springboot.crud.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Author(
        @NotBlank
        val name: String,
        @NotBlank
        val lastName: String,
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1
) {
    private constructor(): this ("","")
}