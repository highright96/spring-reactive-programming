package com.highright.simplechatapplication.controller.dto

data class ArticleRequest(
    val content: String,
    val title: String,
    val username: String,
    val userAvatarImageUrl: String,
)