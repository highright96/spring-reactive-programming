package com.highright.simplechatapplication.service

import com.highright.simplechatapplication.domain.Message

interface MessageService {
    fun latest(): List<Message>
    fun after(lastMessageId: String): List<Message>
    fun post(message: Message)
}