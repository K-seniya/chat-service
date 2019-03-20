package com.grapeup.lab.chatapp.repositories;

import com.grapeup.lab.chatapp.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
