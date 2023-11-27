package com.example.demo.chat;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {

	private final SimpMessagingTemplate messagingTemplate;
	private final ChatService chatMessageService;
    @CrossOrigin(origins = "http://localhost:4200")
	@MessageMapping("/chat")
	public void processMessage(@Payload ChatMessage chatMessage) {
		ChatMessage savedMsg = chatMessageService.save(chatMessage);
		messagingTemplate.convertAndSendToUser(chatMessage.getRecipientId(), "/queue/messages", new ChatNotification(
				savedMsg.getId(), savedMsg.getSenderId(), savedMsg.getRecipientId(), savedMsg.getContent()));
	}
	
	
    @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/messages/{senderId}/{recipientId}")
	public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId,
			@PathVariable String recipientId) {
		System.out.println(senderId+recipientId);
		return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
	}
}