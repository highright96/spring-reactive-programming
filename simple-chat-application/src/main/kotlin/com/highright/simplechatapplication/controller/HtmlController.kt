package com.highright.simplechatapplication.controller

import com.highright.simplechatapplication.service.MessageService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(private val messageService: MessageService) {

    @GetMapping
    fun index(model: Model): String {
        val messages = messageService.latest()

        model["messages"] = messages
        model["lastMessageId"] = messages.lastOrNull()?.id ?: ""
        return "chat"
    }
}