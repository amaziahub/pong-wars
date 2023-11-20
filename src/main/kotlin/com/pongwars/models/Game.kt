package com.pongwars.models

import kotlinx.serialization.Serializable

@Serializable data class Game(val userId: String, val gameId: String? = null)
