package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @SequenceGenerator(name="user_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
    private Integer id;

    private String userName;

    private String pass;

    private String email;
}