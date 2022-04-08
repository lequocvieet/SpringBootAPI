package com.example.user.user.service;


import com.example.user.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    ResponseEntity<?> findById(Integer id);
    Page<User> findAll(Pageable pageable);
    List<Integer> getAllId();

}
