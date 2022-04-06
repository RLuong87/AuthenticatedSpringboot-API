package com.authenticator.authenticator.controllers;

import com.authenticator.authenticator.models.Profile;
import com.authenticator.authenticator.models.auth.User;
import com.authenticator.authenticator.repositories.ProfileRepository;
import com.authenticator.authenticator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/userprofile")
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/profile")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return new ResponseEntity<>(profileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/profile/{id}")
    public @ResponseBody Profile getProfile(@PathVariable Long id) {
        return profileRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // TODO: Save profile to UserRepository

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(profileRepository.save(profile), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Profile updateProfile(@PathVariable Long id, @RequestBody Profile updates) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getCity() != null) profile.setCity(updates.getCity());
        if (updates.getGender() != null) profile.setGender(updates.getGender());
        if (updates.getStatus() != null) profile.setStatus(updates.getStatus());
        if (updates.getState() != null) profile.setState(updates.getState());

        return profileRepository.save(profile);
    }

}
