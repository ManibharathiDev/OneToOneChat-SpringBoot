package com.chatapp.chat.controller;

import com.chatapp.chat.models.Users;
import com.chatapp.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public Users addUser(@Payload Users users)
    {
        System.out.println("Received "+users.getNickName()+"-"+users.getStatus());
        userService.saveUser(users);
        return users;
    }


    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public Users disconnectUser(@Payload Users users)
    {
        userService.disconnect(users);
        return users;
    }


    @GetMapping("/users")
    public ResponseEntity<List<Users>> findConnectedUsers()
    {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }



}
