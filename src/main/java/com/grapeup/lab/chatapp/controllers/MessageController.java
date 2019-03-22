package com.grapeup.lab.chatapp.controllers;

import com.grapeup.lab.chatapp.entities.Message;
import com.grapeup.lab.chatapp.services.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/")
    public Iterable<Message> getAll() {
        return messageService.getAll();
    }

    @PostMapping(value = "/create")
    public Message createMessage(@RequestBody Message message) {
        return messageService.create(message);
    }


}
