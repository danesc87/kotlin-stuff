package com.nanobytes.springboot.crud.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Book (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,
        @NotBlank
        @ManyToMany
        @JoinColumn(name = "author_ids", referencedColumnName = "id")
        val author: List<Author>,
        @NotBlank
        @ManyToOne
        @JoinColumn(name = "type_id", referencedColumnName = "id")
        val type: Type,
        @NotBlank
        @ManyToMany
        @JoinColumn(name = "genre_ids", referencedColumnName = "id")
        val genre: List<Genre>,
        @NotBlank
        val bookName: String
)
