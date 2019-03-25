package com.grapeup.lab.chatapp.services;

import com.grapeup.lab.chatapp.entities.Message;
import com.grapeup.lab.chatapp.repositories.MessageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {
    @Mock
    private MessageRepository repository;

    private MessageService messageService;

    @Before
    public void init() {
        messageService = new MessageService(repository);
    }

    @Test
    public void shouldCreateMessage() {
        // GIVEN
        Message message = new Message();
        Message repoMessage = new Message();
        when(repository.save(message)).thenReturn(repoMessage);

        // WHEN
        Message result = messageService.create(message);

        // THEN
        assertThat(result).isSameAs(repoMessage);
    }

    @Test
    public void shouldGetAll() {
        // GIVEN
        String roomName = "Jokes";
        Message message = new Message();
        when(repository.findByRoom(roomName)).thenReturn(Collections.singletonList(message));

        // WHEN
        Iterable<Message> result = messageService.getAll(roomName);

        // THEN
        assertThat(result).containsExactly(message);
    }

    @Test
    public void shouldDeleteMessages() {
        // GIVEN
        String roomName = "Sport";

        // WHEN
        messageService.removeAll(roomName);

        // THEN
        verify(repository).deleteByRoom(roomName);
    }
}