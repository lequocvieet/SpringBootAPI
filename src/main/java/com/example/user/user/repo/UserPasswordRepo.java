package com.example.user.user.repo;

import com.example.user.user.entity.Address;
import com.example.user.user.entity.User;
import com.example.user.user.entity.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserPasswordRepo extends JpaRepository<Address,Integer> {

    @Query(value = "from UserPassword  x where x.user_name=?1  and x.xoa=false")
    Optional<UserPassword> findByUserName(String username);
}
