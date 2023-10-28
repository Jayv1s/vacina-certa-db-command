package com.vacinacerta.controller;

import com.entities.dto.UsersVaccinesDTO;
import com.vacinacerta.usecase.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersVaccinesController {

    private final IUseCase<UsersVaccinesDTO, UsersVaccinesDTO> insertNewUsersVaccine;

    @Autowired
    private UsersVaccinesController(
            @Qualifier("InsertNewUsersVaccine")
            IUseCase<UsersVaccinesDTO, UsersVaccinesDTO> insertNewUsersVaccine
    ) {
        this.insertNewUsersVaccine = insertNewUsersVaccine;
    }

    @PostMapping("/users/vaccines")
    private ResponseEntity<UsersVaccinesDTO> insertUsersVaccines(@RequestBody UsersVaccinesDTO usersVaccinesDTO) {
        var response = insertNewUsersVaccine.execute(usersVaccinesDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
