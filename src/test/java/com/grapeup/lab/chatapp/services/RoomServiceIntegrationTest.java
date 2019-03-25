package com.grapeup.lab.chatapp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grapeup.lab.chatapp.entities.Room;
import com.grapeup.lab.chatapp.repositories.RoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@RunWith(SpringRunner.class)
public class RoomServiceIntegrationTest {
    @MockBean
    private ObjectMapper mapper;

    @Autowired
    private RoomRepository repository;

    @Test
    public void shouldReturnSavedRoomWithId() {
        // GIVEN
        Room cdmRoom = new Room(null, "room", "345");

        // WHEN
        Room savedRoom = repository.save(cdmRoom);

        // THEN
        assertThat(savedRoom).extracting(Room::getId).isNotNull();
    }

    @Test
    public void shouldGetRoom() {
        // GIVEN
        Room room = new Room(null, "Jokes", "345");
        repository.save(room);

        // WHEN
        Room result = repository.findByRoomNameAndPassword("Jokes", "345");

        // THEN
        assertThat(result).extracting(Room::getPassword).isEqualTo("345");
    }

    @Test
    public void shouldGetRoomWithNullPassword() {
        // GIVEN
        Room room = new Room(null, "JokesWithoutPassword", null);
        repository.save(room);

        // WHEN
        Room result = repository.findByRoomNameAndPassword("JokesWithoutPassword", null);

        // THEN
        assertThat(result).isNotNull();
    }

    @Test
    public void shouldRemoveRoom() {
        // GIVEN
        Room room = new Room(null, "Spam", "345");
        repository.save(room);

        // WHEN
        repository.deleteByRoomNameAndPassword("Spam", "345");

        // THEN
        assertThat(repository.findByRoomNameAndPassword("Spam", "345")).isNull();
    }

    @Test
    public void shouldRemoveRoomWithoutPassword() {
        // GIVEN
        Room room = new Room(null, "SpamWithoutPassword", null);
        repository.save(room);

        // WHEN
        repository.deleteByRoomNameAndPassword("SpamWithoutPassword", null);

        // THEN
        assertThat(repository.findByRoomNameAndPassword("SpamWithoutPassword", null)).isNull();
    }

    @Test(expected = DuplicateKeyException.class)
    public void shouldThrowErrorWhenRoomNameIsNotUnique() {
        // GIVEN
        Room firstRoom = new Room(null, "IT and Maintenance", null);
        Room secondRoom = new Room(null, "IT and Maintenance", "2345");

        // WHEN
        repository.save(firstRoom);
        repository.save(secondRoom);
    }
}
