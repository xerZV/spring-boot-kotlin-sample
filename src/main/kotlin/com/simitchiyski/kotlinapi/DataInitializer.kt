package com.simitchiyski.kotlinapi

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataInitializer(private val bookRepository: BookRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val book1 = Book()
        book1.name = "Name1"
        book1.author = "Author1"
        book1.pages = 365
        book1.publishDate = LocalDate.now()
        bookRepository.save(book1)

        val book2 = Book()
        book2.name = "Name2"
        book2.author = "Author2"
        book2.pages = 133
        book2.publishDate = LocalDate.now()
        bookRepository.save(book2)
    }
}
