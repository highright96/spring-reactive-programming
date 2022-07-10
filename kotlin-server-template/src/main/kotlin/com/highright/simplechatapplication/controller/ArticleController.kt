package com.highright.simplechatapplication.controller

import com.highright.simplechatapplication.controller.dto.ArticleRequest
import com.highright.simplechatapplication.controller.dto.ArticleResponse
import com.highright.simplechatapplication.service.ArticleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(private val articleService: ArticleService) {

    @PostMapping
    suspend fun create(@RequestBody request: ArticleRequest): ResponseEntity<Nothing> {
        articleService.createArticle(request)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/one")
    suspend fun find(): Any {
        return ResponseEntity.ok()
            .body(articleService.find())
    }

    @GetMapping("/all")
    suspend fun findAll(): Any {
        return ResponseEntity.ok()
            .body(articleService.findAll())
    }

    /*
    @GetMapping
    suspend fun showArticles(
        @RequestParam(value = "lastArticleId", defaultValue = "") id: String
    ): ResponseEntity<List<ArticleResponse>> {
        val articles = if (id.isNotEmpty()) {
            articleService.showArticles(id)
        } else {
            articleService.showLatestArticles()
        }

        return if (articles.isEmpty()) {
            with(ResponseEntity.noContent()) {
                header("lastArticleId", id)
                build()
            }
        } else {
            with(ResponseEntity.ok()) {
                header("lastArticleId", articles.last().id)
                body(articles)
            }
        }
    }*/
}