package com.example

import com.example.plugins.configureRouting
import com.example.repository.HeroRepository
import com.example.repository.HeroRepositoryImpl
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() {
        val heroRepository: HeroRepository = HeroRepositoryImpl()
        withTestApplication({ configureRouting(heroRepository) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}
