//package com.nrjtechworld.gemini.controller;
//
//import com.nrjtechworld.gemini.entity.ChatHistory;
//import com.nrjtechworld.gemini.service.ChatHistoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/chat-history")
//public class ChatHistoryController {
//
//    @Autowired
//    private ChatHistoryService chatHistoryService;
//
//
//    @PostMapping("/continue-or-start")
//    public ChatHistory continueOrStartChat(@RequestBody String userMessage, @RequestParam Long userId) {
//
//        Optional<ChatHistory> lastMessage = chatHistoryService.getLastMessageByUserId(userId);
//
//        Long conversationId;
//
//
//        if (lastMessage.isPresent()) {
//            conversationId = lastMessage.get().getConversationId();
//
//            ChatHistory previousMessage = lastMessage.get();
//            previousMessage.setOngoing(false);
//            chatHistoryService.saveChatHistory(previousMessage);
//        } else {
//
//            conversationId = System.currentTimeMillis();
//        }
//
//
//        ChatHistory chatHistory = new ChatHistory();
//        chatHistory.setUserId(userId);
//        chatHistory.setConversationId(conversationId);
//        chatHistory.setMessageText(userMessage);
//        chatHistory.setResponseText("This is a response");
//        chatHistory.setOngoing(true);
//        return chatHistoryService.saveChatHistory(chatHistory);
//    }
//}
