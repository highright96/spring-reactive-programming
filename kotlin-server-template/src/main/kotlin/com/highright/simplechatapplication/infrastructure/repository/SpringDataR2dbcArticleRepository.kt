package com.highright.simplechatapplication.infrastructure.repository

import com.highright.simplechatapplication.common.TABLE_ARTICLES
import com.highright.simplechatapplication.domain.Article
import com.highright.simplechatapplication.domain.ArticleRepository
import io.r2dbc.spi.ConnectionFactory
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.relational.core.query.Criteria.where
import org.springframework.data.relational.core.query.Query.query
import org.springframework.stereotype.Repository

// TODO : 도메인 객체가 infrastructure 계층에 존재, 의존성을 분리해줄 필요가 있음.

@Repository
class SpringDataR2dbcArticleRepository(
    @Qualifier("postgresQLConnectionFactory") private val connectionFactory: ConnectionFactory
) : ArticleRepository {

    private val template: R2dbcEntityTemplate = R2dbcEntityTemplate(connectionFactory)

    override suspend fun save(article: Article): Article =
        template.insert(article).awaitSingle()

    override suspend fun find(id: String): Article =
        template.select(Article::class.java)
            .from(TABLE_ARTICLES)
            .matching(
                query(
                    where("id").`is`(id)
                )
            )
            .one()
            .awaitSingle()

    override suspend fun findAll(): List<Article> {
        return template.select(Article::class.java)
            .from(TABLE_ARTICLES)
            .all()
            .collectList()
            .awaitSingle()
    }

    override suspend fun findLatest(): List<Article> {
        TODO("Not yet implemented")
    }

    override suspend fun findLatest(id: String): List<Article> {
        TODO("Not yet implemented")
    }
}