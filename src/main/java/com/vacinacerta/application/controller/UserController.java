package com.vacinacerta.application.controller;


import com.vacinacerta.domain.entities.dto.UsersDTO;
import com.vacinacerta.domain.usecase.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final IUseCase<UsersDTO, String> insertUser;
    private final IUseCase<UsersDTO, UsersDTO> updateUserData;

    @Autowired
    private UserController(
            @Qualifier("InsertUser")
            IUseCase<UsersDTO, String> insertUser,
            @Qualifier("UpdateUserData")
            IUseCase<UsersDTO, UsersDTO> updateUserData

    ) {
        this.insertUser = insertUser;
        this.updateUserData = updateUserData;
    }

    @PostMapping("/user")
    private ResponseEntity<String> insertUser(@RequestBody UsersDTO user) {
        var response = insertUser.execute(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    private ResponseEntity<UsersDTO> updateUser(@RequestBody UsersDTO user, @PathVariable String id) {
        user.setId(id);
        var response = updateUserData.execute(user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
