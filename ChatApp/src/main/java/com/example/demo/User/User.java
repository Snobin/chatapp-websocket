package com.example.demo.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Document(collection = "chatapp")
public class User {
	@Id
	@Field("nickName")
	private String nickName;
	private Status status;
	private String fullName;


	
}
