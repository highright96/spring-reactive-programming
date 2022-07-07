package com.highright.simplechatapplication.domain

import java.time.Instant

data class Message(
    val content: String,
    val user: User,
    val sent: Instant,
    val id: String? = null
)