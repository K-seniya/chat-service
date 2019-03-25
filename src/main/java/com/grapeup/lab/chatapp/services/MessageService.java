package com.grapeup.lab.chatapp.services;

import com.grapeup.lab.chatapp.entities.Message;
import com.grapeup.lab.chatapp.entities.MessageType;
import com.grapeup.lab.chatapp.repositories.MessageRepository;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message create(Message message) {
        if (MessageType.TYPING == message.getType()) {
            return message;
        }
        return messageRepository.save(message);
    }

    public Iterable<Message> getAll(String roomName) {
         return messageRepository.findByRoom(roomName);
    }

    public Long removeAll(String roomName) {
        return messageRepository.deleteByRoom(roomName);
    }
}
