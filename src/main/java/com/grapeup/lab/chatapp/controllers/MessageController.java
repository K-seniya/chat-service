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

    @PostMapping(value = "/")
    public Iterable<Message> getAll(@RequestBody String roomName) {
        return messageService.getAll(roomName);
    }

    @PostMapping(value = "/remove/{name}")
    public Long removeMessage(@PathVariable String name) {
        return messageService.removeAll(name);
    }


}
