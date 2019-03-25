package com.grapeup.lab.chatapp.repositories;

import com.grapeup.lab.chatapp.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RoomRepository extends MongoRepository<Room, String> {
    @Query("{ 'name' : ?0 , 'password' : ?1}")
    Room findByNameAndPassword(String roomName, String password);

    @Query(value="{'name' : ?0, 'password' : ?1 }", delete = true)
    Long deleteByNameAndPassword(String roomName, String password);
}
