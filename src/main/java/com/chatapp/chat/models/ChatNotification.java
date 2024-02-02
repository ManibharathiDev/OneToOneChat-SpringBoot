package com.chatapp.chat.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ChatNotification {
    private Long id;
    private String senderId;
    private String recipientId;
    private String content;
}
