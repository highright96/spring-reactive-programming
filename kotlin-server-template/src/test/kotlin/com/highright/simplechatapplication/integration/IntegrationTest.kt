package com.highright.simplechatapplication.integration

/*

import com.highright.simplechatapplication.domain.ContentType
import com.highright.simplechatapplication.domain.Message
import com.highright.simplechatapplication.domain.ArticleRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.reactive.server.WebTestClient
import java.net.URL
import java.time.Instant

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = [
        "spring.datasource.url=jdbc:h2:mem:testdb"
    ]
)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class IntegrationTest(private val client: WebTestClient) {

    @Autowired
    lateinit var articleRepository: ArticleRepository

    lateinit var lastMessageId: String

    lateinit var savedMessages: List<Message>

    val now: Instant = Instant.now()

    @BeforeEach
    fun setUp() {
        val secondBeforeNow = now.minusSeconds(1)
        val twoSecondBeforeNow = now.minusSeconds(2)
        savedMessages = articleRepository.saveAll(
            listOf(
                Message(
                    "*testMessage*",
                    ContentType.PLAIN,
                    twoSecondBeforeNow,
                    "test",
                    "http://test.com"
                ),
                Message(
                    "**testMessage2**",
                    ContentType.PLAIN,
                    secondBeforeNow,
                    "test1",
                    "http://test.com"
                ),
                Message(
                    "`testMessage3`",
                    ContentType.PLAIN,
                    now,
                    "test2",
                    "http://test.com"
                )
            )
        ).toList()
        lastMessageId = savedMessages.first().id ?: ""
    }

    @AfterEach
    fun tearDown() {
        articleRepository.deleteAll()
    }

    @Test
    fun `test that mesages API return latest messages`() {
        this.client
            .get()
            .uri("/api/v1/messages?lastMessageId=$lastMessageId")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$[0].id").isEqualTo(savedMessages[1].id!!)
            .jsonPath("$[1].id").isEqualTo(savedMessages[2].id!!)
    }

    // TODO : Bad Request (400) 이 반환되는 이유 찾아야함.
    @Test
    @Disabled
    fun `test that messages posted to the API is stored`() {
        val url = URL("https://blog.12min.com/wp-content/uploads/2018/05/27d-William-Shakespeare.jpg").toString()
        val sent = now.toString()

        this.client
            .post()
            .uri("/api/v1/messages")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(
                """
                "content" : "내용",
                "user" : {
                            "name" : "이름"
                            "avatarImageLink" : $url
                        },
                "sent" : $sent
            """.trimIndent()
            )
            .exchange()
            .expectStatus().isOk

        val expected = articleRepository.findAll().toList()

        Assertions.assertEquals(expected.size, 1)
    }
}*/