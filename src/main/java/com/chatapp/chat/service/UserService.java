package com.chatapp.chat.service;

import com.chatapp.chat.models.Status;
import com.chatapp.chat.models.Users;
import com.chatapp.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(Users users)
    {
        users.setStatus(0);
        userRepository.save(users);
    }

    public void disconnect(Users users)
    {
        var storedUser =userRepository.findById(users.getId()).orElse(null);
        if(storedUser != null)
        {
            storedUser.setStatus(1);
            userRepository.save(storedUser);
        }
    }

    public List<Users> findConnectedUsers(){
        return userRepository.findAllByStatus(0);
    }

}
