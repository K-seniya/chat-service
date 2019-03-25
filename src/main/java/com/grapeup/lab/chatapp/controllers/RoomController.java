package com.grapeup.lab.chatapp.controllers;

import com.grapeup.lab.chatapp.entities.Room;
import com.grapeup.lab.chatapp.services.MessageService;
import com.grapeup.lab.chatapp.services.RoomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;
    private MessageService messageService;

    public RoomController(RoomService roomService, MessageService messageService) {
        this.roomService = roomService;
        this.messageService = messageService;
    }

    @PostMapping(value= "/create")
    public Room create(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @PostMapping(value = "/delete")
    public boolean delete(@RequestBody Room room) {
        messageService.removeAll(room.getName());
        return roomService.deleteRoom(room);
    }

    @PostMapping("/")
    public boolean isExist(@RequestBody Room room) {
        return roomService.isExist(room);
    }

}
