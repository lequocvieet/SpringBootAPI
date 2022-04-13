package com.example.user.user.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_password")
public class UserPassword {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String user_name;


    @Column(name="user_password")
    private String password;


    @Column(name = "xoa")
    private Boolean xoa;





}
