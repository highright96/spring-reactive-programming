package com.highright.simplechatapplication.domain


interface ArticleRepository {
    suspend fun save(article: Article): Article
    suspend fun find(id: String): Article
    suspend fun findAll(): List<Article>
    suspend fun findLatest(): List<Article>
    suspend fun findLatest(id: String): List<Article>
}