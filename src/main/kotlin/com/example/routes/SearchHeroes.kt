package com.example.routes

import com.example.repository.HeroRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.searchHeroes(heroRepository: HeroRepository) {
    get("/boruto/heroes/search") {
        val name = call.request.queryParameters["name"]

        val apiResponse = heroRepository.searchHero(name = name)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }

}