package com.chatapp.chat.controller;

import com.chatapp.chat.models.Users;
import com.chatapp.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final UserService userService;
    @PostMapping("/auser")
    public String printData(@RequestBody Users users)
    {
        System.out.println("Received "+users.getNickName()+"-"+users.getStatus());
        userService.saveUser(users);
        return "Added";
    }

}
