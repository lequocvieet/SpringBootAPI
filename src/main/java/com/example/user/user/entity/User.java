package com.example.user.user.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_info")
public class User {

    @Id
    @Column(name = "id")
    private  Integer id;


    @Column(name="email")
    private String email;



    @Column(name = "date_of_birth")
    private Date dateOfBirth;


    @Column(name = "xoa")
    private Boolean xoa;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;


    @OneToOne
    @JoinColumn(name = "password_id")
    private UserPassword userPassword;

}
