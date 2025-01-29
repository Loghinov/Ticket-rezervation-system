package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-user-by-id")
    public ResponseEntity<UserDto> getUserById(@RequestParam long userId) {
        try {
            UserDto userDto = userService.getUserById(userId);
            if (userDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save-user")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        try {
            userDto = userService.addUser(userDto);
            if (userDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-user")
    public ResponseEntity<UserDto> update(@PathVariable long userId, @Valid @RequestBody UserDto userDto) {
        try {
            userDto = userService.update(userId, userDto);
            if (userDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<String> delete(@PathVariable long userId) {
            userService.delete(userId);
            return ResponseEntity.ok("User deleted Successfully");
    }
}