package com.jowl.feign.controllers;

import com.jowl.feign.clients.UserClient;
import com.jowl.feign.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserClient userClient;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userClient.findAll();
        LOGGER.info("{}", users);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        User user = userClient.findById(id);
        LOGGER.info("{}", user);
        return ResponseEntity.ok(user);
    }

}
