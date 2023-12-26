package com.example

import com.example.plugins.*
import com.example.repository.HeroRepository
import com.example.repository.HeroRepositoryImpl
import io.ktor.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    val heroRepository: HeroRepository = HeroRepositoryImpl()

    configureDefaultHeader()
    configureStatusPages()
    configureSerialization()
    configureMonitoring()
    configureRouting(heroRepository)
}
