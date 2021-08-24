package com.simitchiyski.kotlinapi

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDate
import javax.persistence.*

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
data class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        val id: Long? = null,

        @Column(name = "name", unique = true, nullable = false)
        var name: String? = null,

        @Column(name = "author", nullable = false)
        var author: String? = null,

        @Column(name = "pages", nullable = false)
        var pages: Int? = null,

        @Column(name = "publish_date", nullable = false)
        var publishDate: LocalDate? = null
)
