package com.grapeup.lab.chatapp.services;

import com.grapeup.lab.chatapp.entities.Message;
import com.grapeup.lab.chatapp.repositories.MessageRepository;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message create(Message message) {
        return messageRepository.save(message);
    }

    public Iterable<Message> getAll() {
         return messageRepository.findAll();
    }
}
