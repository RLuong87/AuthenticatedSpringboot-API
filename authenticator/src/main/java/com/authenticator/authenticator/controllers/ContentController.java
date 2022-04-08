package com.authenticator.authenticator.controllers;

import com.authenticator.authenticator.models.Content;
import com.authenticator.authenticator.models.auth.User;
import com.authenticator.authenticator.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentRepository contentRepository;

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
