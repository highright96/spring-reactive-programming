package com.highright.simplechatapplication.domain

import com.highright.simplechatapplication.common.TABLE_ARTICLES
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table(TABLE_ARTICLES)
data class Article(
    @Id var id: String = ARTICLE_ID_PREFIX.uuid(),
    val content: String,
    val title: String,
    val username: String,
    val userAvatarImageUrl: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)

const val ARTICLE_ID_PREFIX = "article-id-"

fun String.uuid(): String = this + UUID.randomUUID().toString()