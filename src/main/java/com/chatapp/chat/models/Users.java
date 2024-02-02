package com.chatapp.chat.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nick_name")
    private String nickName;

    @Column(name="full_name")
    private String fullName;

    private int status;


}
