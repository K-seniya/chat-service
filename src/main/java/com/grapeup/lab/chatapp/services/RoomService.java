package com.grapeup.lab.chatapp.services;

import com.grapeup.lab.chatapp.entities.Room;
import com.grapeup.lab.chatapp.repositories.RoomRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }
}
