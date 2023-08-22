package com.blog.blogspringbackend.controllers;

import com.blog.blogspringbackend.payloads.ApiResponse;
import com.blog.blogspringbackend.payloads.UserDto;
import com.blog.blogspringbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Mapping to create a user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Mapping to delete a user
    @DeleteMapping("/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId) {
        try {
            this.userService.deleteUser(Integer.parseInt(userId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mapping to get a user
    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        return this.userService.getUserById(Integer.parseInt(userId));
    }

    // Mapping to update a user
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDto userDto,
                                                  @PathVariable String userId) {
        try {
            this.userService.updateUser(userDto,
                    Integer.parseInt(userId));
            
            return new ResponseEntity<>(new ApiResponse("user deleted successfully",
                    false),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("unable to delete user",
                    true),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
