package com.example.plugins


import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import java.time.Duration

fun Application.configureDefaultHeader() {
    install(DefaultHeaders) {
        val oneYearToSeconds = Duration.ofDays(365).toSeconds()
        header(HttpHeaders.CacheControl, "public, max-age=$oneYearToSeconds, immutable")
    }
}