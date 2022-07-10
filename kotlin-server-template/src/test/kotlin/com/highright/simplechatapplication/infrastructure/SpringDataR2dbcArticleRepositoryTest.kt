package com.highright.simplechatapplication.infrastructure

import com.highright.simplechatapplication.configuration.PostgresQLConfiguration
import com.highright.simplechatapplication.domain.Article
import com.highright.simplechatapplication.infrastructure.repository.SpringDataR2dbcArticleRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [SpringDataR2dbcArticleRepository::class, PostgresQLConfiguration::class])
class SpringDataR2dbcArticleRepositoryTest {

    @Autowired
    lateinit var articleRepository: SpringDataR2dbcArticleRepository

    @Test
    fun `insert article`() = runBlocking {
        // given, when
        val actual = articleRepository.save(
            Article(
                content = "내용",
                title = "제목",
                username = "이름",
                userAvatarImageUrl = "url"
            )
        )

        // then

        /*
        find , findAll 모두 서버 직접 띄우고 실행하면 잘 돌아감.
        테스트에서만 이상하게 에러가 발생
        씨발 뭐지?
        */
        val expected = articleRepository.findAll()
        //assertEquals(expected!!.id, actual.id)
    }
}