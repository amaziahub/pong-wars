package com.pongwars.routes

import com.pongwars.models.Game
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Route.gameRouting() {
    route("/games") {
        post {
            val gameRequest = call.receive<Game>()
            val newGame = Game(gameRequest.userId, UUID.randomUUID().toString())
            call.respond(HttpStatusCode.Created, newGame)
        }
    }
}