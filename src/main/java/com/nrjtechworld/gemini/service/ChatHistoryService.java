//package com.nrjtechworld.gemini.service;
//
//import com.nrjtechworld.gemini.entity.ChatHistory;
//import com.nrjtechworld.gemini.repository.ChatHistoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ChatHistoryService {
//
//    @Autowired
//    private ChatHistoryRepository chatHistoryRepository;
//
//
//    public Optional<ChatHistory> getLastMessageByUserId(Long userId) {
//        return chatHistoryRepository.findTopByUserIdAndIsOngoingOrderByTimestampDesc(userId, true);
//    }
//
//
//    public void saveChatHistory(Long userId, Long conversationId, String messageText, String responseText) {
//        // Create a new ChatHistory object
//        ChatHistory chatHistory = new ChatHistory();
//
//        // Set the properties
//        chatHistory.setUserId(userId);
//        chatHistory.setConversationId(conversationId);
//        chatHistory.setMessageText(messageText);
//        chatHistory.setResponseText(responseText);
//        chatHistory.setIsOngoing(true);  // Assuming the conversation is ongoing when saving it
//
//        // Save the ChatHistory object to the repository
//        chatHistoryRepository.save(chatHistory);
//    }
//    public List<ChatHistory> getChatHistoryByUserId(Long userId) {
//        return chatHistoryRepository.findAllByUserIdAndIsOngoing(userId, true);
//    }
//}
//
