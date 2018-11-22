package com.nanobytes.springboot.crud.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Genre(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,
        @ManyToOne
        @JoinColumn(name = "type_id", referencedColumnName = "id")
        val type: Type,
        @NotBlank
        val genreName: String
)
