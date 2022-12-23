package com.example.demo.controllers;

import com.example.demo.entities.Bill;
import com.example.demo.entities.User;
import com.example.demo.repositories.BillRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    BillRepository billRepository;


    @GetMapping
    public List<User> getUserAll() {
        return userRepository.findAll();
    }


    @GetMapping("/{id}")
    public User getUserbyId(@PathVariable int id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    @GetMapping("{user}/bills")
    public List<Bill> getBillsByUser(@PathVariable String user) {
        User usuario = userRepository.findByuserName(user);

        if(!usuario.getUserName().equals(null)){
            return usuario.getBills();
        }

        return null;
    }

    @GetMapping("{user}/bills/{bill_id}")
    public Bill getBillbyId(@PathVariable String user, Integer bill_id) {
        User usuario = userRepository.findByuserName(user);

        if(!usuario.getUserName().equals(null)){
            return usuario.getBills().get(bill_id);
        }

        return null;
    }

    @PostMapping
    public User postUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }
}
