package com.example.user.user.controller;


import com.example.user.user.entity.User;
import com.example.user.user.response.MyResponse;
import com.example.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/find-by-id")
    public ResponseEntity<?> findById(@RequestParam(name="id",required = false) Integer id) {
        return userService.findById(id);

    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
                                     @RequestParam(name = "size", defaultValue = "10", required = false) Integer size){


        Pageable pageable = PageRequest.of(page - 1, size);
        Page<User> userPage = userService.findAll(pageable);
        return ResponseEntity.ok(userPage);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        MyResponse response = userService.addUser(user);
        return ResponseEntity.ok(response);
    }






}
