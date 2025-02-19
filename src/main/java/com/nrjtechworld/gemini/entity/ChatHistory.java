package com.nrjtechworld.gemini.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "chat_history")
public class ChatHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private Long userId;

    private Long conversationId;

    private String messageText;
    private String responseText;

    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;

    private boolean isOngoing;

    @PrePersist
    public void prePersist() {
        timestamp = LocalDateTime.now();
    }
}
