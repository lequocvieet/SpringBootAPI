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
@Table(name = "address")
public class Address {

    @Id
    @Column(name="id")
    private Integer id;


    @Column(name = "district")
    private String district;


    @Column(name = "street")
    private  String street;


    @Column(name = "city")
    private String city;


    @Column(name = "xoa")
    private Boolean xoa;

}
