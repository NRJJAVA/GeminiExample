package com.nrjtechworld.gemini.repository;

import com.nrjtechworld.gemini.entity.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {
    Optional<ChatHistory> findTopByUserIdAndIsOngoingOrderByTimestampDesc(Long userId, boolean isOngoing);

    // Find all messages for an ongoing conversation by userId
    List<ChatHistory> findAllByUserIdAndIsOngoing(Long userId, boolean isOngoing);
}

