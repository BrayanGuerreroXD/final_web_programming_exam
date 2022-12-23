package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name="users_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_id_seq")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "pass")
    private String pass;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private List<Bill> bills;
}