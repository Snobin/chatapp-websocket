package com.example.demo.User;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.demo.feign.JWTFeignClient;

import io.swagger.v3.oas.annotations.Operation;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JWTFeignClient client;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @MessageMapping("/user.adduser")
    @SendTo("/user/public")
    @Operation
    public UserDto addUser(@Payload UserDto user, @RequestHeader("Authorization") String token) {
        System.out.println("Received");

        // Assuming you have a method in FeigClient to validate the token
        if (client.validateToken(token)) {
            userService.saveUser(user);
            return user;
        } else {
            logger.warn("Invalid token received for user: {}", token);
            // Handle invalid token scenario
            return null;
        }
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    @Operation
    public User disconnectUser(@Payload User user) {
        userService.disconnect(user);
        return user;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    @Operation
    public ResponseEntity<List<User>> findConnectedUsers() {
        // You can call other methods in FeigClient if needed
        List<User> connectedUsers = userService.findConnectedUsers();
        return ResponseEntity.ok(connectedUsers);
    }
}
