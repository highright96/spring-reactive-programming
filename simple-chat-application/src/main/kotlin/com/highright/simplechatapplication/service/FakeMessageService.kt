package com.highright.simplechatapplication.service

import com.highright.simplechatapplication.domain.Message
import org.springframework.stereotype.Service
import java.time.Instant
import kotlin.random.Random

@Service
class FakeMessageService : MessageService {

    override fun latest(): List<Message> {
        val count = Random.nextInt(1, 15)
        return (0..count).map {
            val user = MockData.users.values.random()
            val userQuote = MockData.usersQuotes.getValue(user.name).invoke()

            Message(
                content = userQuote,
                user = user,
                sent = Instant.now(),
                id = Random.nextBytes(10).toString()
            )
        }
    }

    override fun after(lastMessageId: String): List<Message> {
        return latest()
    }

    override fun post(message: Message) {
        TODO("Not yet implemented")
    }
}