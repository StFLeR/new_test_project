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

    @GetMapping("/srv/users")
    public Iterable<Users> findAll(){return usersService.findAll();}

    @GetMapping("/srv/users/{id}")
    public Users gateOne(@PathVariable("id") Integer id){
        return usersService.gateOne(id);
    }

    @PostMapping("/srv/users")
    public UserDTO create(@RequestBody UserDTO userDTO){
        return usersService.create(userDTO);
    }

    @PutMapping("/srv/users/{id}")
    public Users update (@PathVariable("id") Integer id,@RequestBody UserDTO userDTO){
        return usersService.update(id, userDTO);
    }
}
