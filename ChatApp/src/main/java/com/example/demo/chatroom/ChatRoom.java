package com.example.demo.chatroom;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document
public class ChatRoom {
	@Id
	private String id;
	private String chatId;
	private String senderId;
	private String recipientId;

}
