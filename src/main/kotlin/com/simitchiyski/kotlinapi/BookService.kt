package com.simitchiyski.kotlinapi

interface BookService {
    fun findAll(): List<Book>

    fun getById(id: Long): Book

    fun create(book: Book): Book

    fun updateById(id: Long, book: Book): Book

    fun deleteById(id: Long)
}
