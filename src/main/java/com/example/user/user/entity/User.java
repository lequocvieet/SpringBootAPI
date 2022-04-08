package com.example.user.user.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private  Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name = "password")
    private String password;


    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "hometown")
    private String hometown;

    @Column(name = "xoa")
    private Boolean xoa;

}
