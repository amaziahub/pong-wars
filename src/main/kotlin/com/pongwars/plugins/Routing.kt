package com.pongwars.plugins

import com.pongwars.routes.gameRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        gameRouting()
    }
}
