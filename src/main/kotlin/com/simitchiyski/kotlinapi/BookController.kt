package com.simitchiyski.kotlinapi

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController(private val bookService: BookService) {

    @GetMapping
    fun getAllEmployees(): List<Book> = bookService.findAll()

    @GetMapping("/{id}")
    fun getEmployeesById(@PathVariable("id") id: Long): Book = bookService.getById(id)

    @PostMapping
    fun createEmployee(@RequestBody payload: Book): Book = bookService.create(payload)

    @PutMapping("/{id}")
    fun updateEmployeeById(@PathVariable("id") id: Long, @RequestBody payload: Book): Book = bookService.updateById(id, payload)

    @DeleteMapping("/{id}")
    fun deleteEmployeesById(@PathVariable("id") id: Long): Unit = bookService.deleteById(id)
}
