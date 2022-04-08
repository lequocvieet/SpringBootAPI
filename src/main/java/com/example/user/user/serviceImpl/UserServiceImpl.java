package com.example.user.user.serviceImpl;

import com.example.user.user.entity.User;
import com.example.user.user.repo.UserRepo;
import com.example.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<User> userOptional=userRepo.findById(id);
        if (userOptional.isPresent()){
        return ResponseEntity.ok(userOptional.get());
        }
        else {
            return  ResponseEntity.ok("User does not exist!");
        }
       }

    @Override
    public Page<User> findAll(Pageable pageable) {
            try{
                return userRepo.findAll(pageable);
            } catch(Exception e){
                return  Page.empty();
            }
    }

    public List<Integer> getAllId(){
    return  userRepo.getAllId();
    }



}
