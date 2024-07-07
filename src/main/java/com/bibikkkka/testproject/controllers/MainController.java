package com.bibikkkka.testproject.controllers;

import com.bibikkkka.testproject.dto.UserDTO;
import com.bibikkkka.testproject.entities.User;
import com.bibikkkka.testproject.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_controller")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;

    @Operation(
            summary = "Adding new user",
            description = "Get User's DTO to build and save new user"
    )
    @PostMapping("/api/add")
    public void addUser(@RequestBody UserDTO userDTO) {

        log.info("New row: {}", userRepository.save(User.builder()
                        .age(userDTO.getAge())
                        .weight(userDTO.getWeight())
                        .name(userDTO.getName())
                        .build())
        );
    }

    @GetMapping("/api/all")
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api/get")
    public User getUserById(@RequestParam int id) {
        return userRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/api/del")
    public void deleteUserById(@RequestParam int id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/api/put")
    public String updateUserById(@RequestBody User user) {
        if (!userRepository.existsById(user.getId())) {
            return "No such row";
        }
        return userRepository.save(user).toString();
    }

}
