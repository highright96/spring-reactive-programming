package com.highright.simplechatapplication.service

import com.highright.simplechatapplication.controller.dto.ArticleRequest
import com.highright.simplechatapplication.controller.dto.ArticleResponse
import com.highright.simplechatapplication.domain.ArticleRepository
import com.highright.simplechatapplication.service.mapper.ArticleMappers
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Primary
@Service
class PersistentArticleService(private val articleRepository: ArticleRepository) : ArticleService {

    private val messageMapper = Mappers.getMapper(ArticleMappers::class.java)

    override suspend fun createArticle(request: ArticleRequest) {
        articleRepository.save(
            messageMapper.toArticle(request)
        )
    }

    override suspend fun find() = articleRepository.find("article-id-e66653d7-96f9-4d88-bfd2-f05090c54ace")

    override suspend fun findAll() = articleRepository.findAll()
    /*
    override suspend fun showLatestArticles(): List<ArticleResponse> =
        articleRepository.findLatest()
            .map { messageMapper.toArticleResponse(it) }

    override suspend fun showArticles(lastArticleId: String): List<ArticleResponse> =
        articleRepository.findLatest(lastArticleId)
            .map { messageMapper.toArticleResponse(it) }*/
}