package com.example.plugins

import com.example.repository.HeroRepository
import com.example.routes.getAllHeroes
import com.example.routes.root
import com.example.routes.searchHeroes
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.routing.*

fun Application.configureRouting(heroRepository: HeroRepository) {
    routing {
        root()
        getAllHeroes(heroRepository)
        searchHeroes(heroRepository)

        static("/images") {
            resources("images")
        }
    }
}
