package com.chatapp.chat.repository;

import com.chatapp.chat.models.Status;
import com.chatapp.chat.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {

    List<Users> findAllByStatus(int status);
}
