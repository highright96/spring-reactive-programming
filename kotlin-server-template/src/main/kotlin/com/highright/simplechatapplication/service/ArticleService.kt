package com.highright.simplechatapplication.service

import com.highright.simplechatapplication.controller.dto.ArticleRequest
import com.highright.simplechatapplication.controller.dto.ArticleResponse
import com.highright.simplechatapplication.domain.Article

interface ArticleService {
    suspend fun createArticle(request: ArticleRequest)
    suspend fun findAll(): List<Article>
    //suspend fun showArticles(lastMessageId: String): List<ArticleResponse>
    //suspend fun showLatestArticles(): List<ArticleResponse>
    suspend fun find(): Article
}