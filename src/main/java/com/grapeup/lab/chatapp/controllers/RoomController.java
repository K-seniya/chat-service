package com.grapeup.lab.chatapp.controllers;

import com.grapeup.lab.chatapp.entities.Room;
import com.grapeup.lab.chatapp.services.RoomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "/{id}")
    public Room getRoom(@PathVariable String id){
        return null;
    }

    @PostMapping(value= "/create")
    public Room create(@RequestBody Room room) {
        return roomService.createRoom(room);
    }
}
