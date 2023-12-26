package com.example.routes

import com.example.model.ApiResponse
import com.example.repository.HeroRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getAllHeroes(heroRepository: HeroRepository) {



    get("/boruto/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            val apiResponse = heroRepository.getAllHeroes(page = page)
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )

        } catch (ex: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only numbers allowed in query parameter."),
                status = HttpStatusCode.BadRequest
            )
        } catch (ex: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Heroes not found"),
                status = HttpStatusCode.BadRequest
            )
        }
    }
}