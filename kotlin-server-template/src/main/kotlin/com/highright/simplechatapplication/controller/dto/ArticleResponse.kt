package com.highright.simplechatapplication.controller.dto

import java.time.LocalDateTime

data class ArticleResponse(
    val id: String,
    val content: String,
    val title: String,
    val user: UserResponse,
    val createdAt: LocalDateTime
)