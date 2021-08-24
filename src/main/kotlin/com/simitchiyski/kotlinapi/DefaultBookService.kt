package com.simitchiyski.kotlinapi

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class DefaultBookService(private val bookRepository: BookRepository) : BookService {
    override fun findAll(): List<Book> = bookRepository.findAll()

    override fun getById(id: Long): Book = bookRepository.findById(id)
            .orElseThrow{ResponseStatusException(NOT_FOUND, "Book not found")}

    @Transactional
    override fun create(book: Book): Book = bookRepository.save(book)

    @Transactional
    override fun updateById(id: Long, book: Book): Book {
        return if (bookRepository.existsById(id)) {
            val fetchedBook = bookRepository.getById(id);
            fetchedBook.name = book.name
            fetchedBook.author = book.author
            fetchedBook.pages = book.pages
            fetchedBook.publishDate = book.publishDate

            bookRepository.save(fetchedBook)
        } else {
            throw ResponseStatusException(NOT_FOUND, "Book not found")
        }
    }

    @Transactional
    override fun deleteById(id: Long) {
        return if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id)
        } else throw ResponseStatusException(NOT_FOUND, "Book not found")
    }
}
