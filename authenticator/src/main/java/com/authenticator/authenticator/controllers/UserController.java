package com.authenticator.authenticator.controllers;

import com.authenticator.authenticator.models.auth.User;
import com.authenticator.authenticator.repositories.UserRepository;
import com.authenticator.authenticator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//@CrossOrigin
//@RestController
//@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;

//    @GetMapping("/self")
//    public @ResponseBody User getSelf() {
//        User currentUser = userService.getCurrentUser();
//
//        if (currentUser == null) {
//            return null;
//        }
//        return (User) userRepository.findByUser_id(currentUser.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
}
