package com.test.new_test_project.persistence.controller;

import com.test.new_test_project.persistence.entity.Users;
import com.test.new_test_project.persistence.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aamitreikin on 06.06.17.
 */
@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/api/v1/users")
    public Iterable<Users> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/api/v1/users/{id}")
    public UserDTO gateOne(@PathVariable("id") Integer id) {
        return usersService.gateOne(id);
    }

    @PostMapping("/api/v1/users")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return usersService.create(userDTO);
    }

    @PutMapping("/api/v1/users/{id}")
    public UserDTO update(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        return usersService.update(id, userDTO);
    }

    @DeleteMapping("/api/v1/users/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return usersService.delete(id);
    }

    //вывести всех юзеров которым равен bank_ofice_id
    @GetMapping("/api/v1/users/bankOfice/{id}")
    public Iterable<Users> findAllUsers(@PathVariable("id") Long id) {
        return usersService.findAllUsers(id);
    }
}
