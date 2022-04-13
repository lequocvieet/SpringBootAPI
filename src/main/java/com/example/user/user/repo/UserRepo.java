package com.example.user.user.repo;

import com.example.user.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {


    @Query(value = "from User u where  u.xoa=false")
    Page<User> findAll(Pageable pageable);


    @Query(value = "select u.id from User u where u.xoa=false ")
    List<Integer> getAllId();


    @Query(value = "from User u where u.id=?1 and u.xoa=false")
    Optional<User> findById(Integer id);





}
