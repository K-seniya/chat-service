package com.grapeup.lab.chatapp.services;

import com.grapeup.lab.chatapp.entities.Room;
import com.grapeup.lab.chatapp.repositories.RoomRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<String> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(Room::getName)
                .collect(Collectors.toList());
    }

    public boolean isExist(Room room) {
        return roomRepository.findByNameAndPassword(room.getName(), room.getPassword()) != null;
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public boolean deleteRoom(Room room) {
        return roomRepository.deleteByNameAndPassword(room.getName(), room.getPassword()) > 0L;
    }
}
