package com.authenticator.authenticator.controllers;

import com.authenticator.authenticator.models.Content;
import com.authenticator.authenticator.models.Profile;
import com.authenticator.authenticator.models.auth.User;
import com.authenticator.authenticator.repositories.ContentRepository;
import com.authenticator.authenticator.repositories.ProfileRepository;
import com.authenticator.authenticator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/content")
    public ResponseEntity<List<Content>> getAllContent() {
        return new ResponseEntity<>(contentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/content/{id}")
    public @ResponseBody Content getContent(@PathVariable Long id) {
        return contentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody Content content) {
        return new ResponseEntity<>(contentRepository.save(content), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Content updateContent(@PathVariable Long id, @RequestBody Content updates) {
        Content content = contentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getUserContent() != null) content.setUserContent(updates.getUserContent());

        return contentRepository.save(content);
    }
}
