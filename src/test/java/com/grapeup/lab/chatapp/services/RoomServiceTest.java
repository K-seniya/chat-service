package com.grapeup.lab.chatapp.services;

import com.grapeup.lab.chatapp.entities.Room;
import com.grapeup.lab.chatapp.repositories.RoomRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceTest {
    @Mock
    private RoomRepository repository;

    private RoomService roomService;

    @Before
    public void init() {
        roomService = new RoomService(repository);
    }

    @Test
    public void shouldGetAll() {
        // GIVEN
        Room firstRoom = new Room("1", "first room", "123");
        Room secondRoom = new Room("2", "second room", null);
        when(repository.findAll()).thenReturn(Arrays.asList(firstRoom, secondRoom));

        // WHEN
        List<String> result = roomService.getAllRooms();

        // THEN
        assertThat(result).containsExactlyInAnyOrder("first room", "second room");
    }

    @Test
    public void shouldCreateRoom() {
        // GIVEN
        Room cdmRoom = new Room(null, "room", null);
        Room modelRoom = new Room("1", "room", null);
        when(repository.save(cdmRoom)).thenReturn(modelRoom);

        // WHEN
        Room createdRoom = roomService.createRoom(cdmRoom);

        // THEN
        assertThat(createdRoom).extracting(Room::getId, Room::getName, Room::getPassword).contains("1", "room", null);
    }

}