package com.example.demo.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
		@Autowired
		private  UserService userService;

	    @MessageMapping("/user.adduser")
//	    @SendTo("/user/public")
	    public User addUser(
	            @Payload User user
	    ) {
	    	System.out.println("Received");
	        userService.saveUser(user);
	        return user;
	    }

	    @MessageMapping("/user.disconnectUser")
	    @SendTo("/user/public")
	    public User disconnectUser(
	            @Payload User user
	    ) {
	        userService.disconnect(user);
	        return user;
	    }

	    @GetMapping("/users")
	    public ResponseEntity<List<User>> findConnectedUsers() {
	        return ResponseEntity.ok(userService.findConnectedUsers());
	    }
}
