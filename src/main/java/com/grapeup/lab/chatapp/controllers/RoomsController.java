package com.grapeup.lab.chatapp.controllers;

import com.grapeup.lab.chatapp.services.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
    private RoomService roomService;

    public RoomsController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    public List<String> getAll() {
        return roomService.getAllRooms();
    }
}
