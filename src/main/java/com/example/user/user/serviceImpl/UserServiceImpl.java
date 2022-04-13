package com.example.user.user.serviceImpl;

import com.example.user.user.entity.User;
import com.example.user.user.entity.UserPassword;
import com.example.user.user.repo.UserPasswordRepo;
import com.example.user.user.repo.UserRepo;
import com.example.user.user.response.MyResponse;
import com.example.user.user.service.UserService;
import com.example.user.user.utility.ValidateEmailPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserPasswordRepo userPasswordRepo;

    public ValidateEmailPhone validateEmailPhone;

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

    @Override
    public MyResponse addUser(User user) {
        MyResponse response = new MyResponse();

        Optional<User> userOptional=userRepo.findById(user.getId());
        Optional<UserPassword> optionalUserPassword=userPasswordRepo.findByUserName(user.getUserPassword().getUser_name());
        if (optionalUserPassword.isPresent()){
            response.setResult(-1,"User  name already exist");
            return response;
        }
        if(userOptional.isPresent()){
            response.setResult(-1,"User id already exist");
            return response;
        }else if(! (validateEmailPhone.validateEmail(user.getEmail()))){
            response.setResult(-1, "Email is not valid");
            return  response;
        } else if (!(validateEmailPhone.validateDate(user.getDateOfBirth()))) {
            response.setResult(-1,"Date of birth is not valid");

        }else {
            userRepo.save(user);
            response.success();

        }
        return  response;
    }


}
