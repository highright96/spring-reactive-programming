package com.highright.simplechatapplication.controller

import com.highright.simplechatapplication.domain.Message
import com.highright.simplechatapplication.service.MessageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/messages")
class RestController(private val messageService: MessageService) {

    @GetMapping
    fun latest(
        @RequestParam(value = "lastMessageId", defaultValue = "") id: String
    ): ResponseEntity<List<Message>> {
        val messages = if (id.isNotEmpty()) {
            messageService.after(id)
        } else {
            messageService.latest()
        }

        return if (messages.isEmpty()) {
            with(ResponseEntity.noContent()) {
                header("lastMessageId", id)
                build()
            }
        } else {
            with(ResponseEntity.ok()) {
                header("lastMessageId", messages.last().id)
                body(messages)
            }
        }
    }

    @PostMapping
    fun post(@RequestBody message: Message) {
        messageService.post(message)
    }
}