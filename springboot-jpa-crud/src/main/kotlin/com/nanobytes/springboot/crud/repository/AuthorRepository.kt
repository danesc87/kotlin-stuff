package com.nanobytes.springboot.crud.repository

import com.nanobytes.springboot.crud.model.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository: CrudRepository<Author, Long> {
    fun findByname(name: String): Iterable<Author>
}