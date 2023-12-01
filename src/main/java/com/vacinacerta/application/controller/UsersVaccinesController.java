package com.vacinacerta.application.controller;

import com.vacinacerta.application.context.UserVaccineContext;
import com.vacinacerta.domain.entities.db.UsersVaccines;
import com.vacinacerta.domain.entities.dto.UsersVaccinesDTO;
import com.vacinacerta.domain.usecase.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersVaccinesController {

    private final IUseCase<UserVaccineContext, UsersVaccinesDTO> insertNewUsersVaccine;
    private final IUseCase<UserVaccineContext, List<UsersVaccines>> insertVaccinesInBatchIntoUser;

    @Autowired
    private UsersVaccinesController(
            @Qualifier("InsertNewUsersVaccine")
            IUseCase<UserVaccineContext, UsersVaccinesDTO> insertNewUsersVaccine,
            @Qualifier("InsertVaccinesInBatchIntoUser")
            IUseCase<UserVaccineContext, List<UsersVaccines>> insertVaccinesInBatchIntoUser
    ) {
        this.insertNewUsersVaccine = insertNewUsersVaccine;
        this.insertVaccinesInBatchIntoUser = insertVaccinesInBatchIntoUser;
    }

    @PostMapping("/users/{userId}/vaccines")
    private ResponseEntity<UsersVaccinesDTO> insertUsersVaccines(@PathVariable String userId, @RequestBody UsersVaccinesDTO usersVaccinesDTO) {
        UserVaccineContext context = UserVaccineContext.builder()
                .userId(userId)
                .usersVaccinesDTO(usersVaccinesDTO)
                .build();
        var response = insertNewUsersVaccine.execute(context);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/users/{userId}/vaccines/batch")
    private ResponseEntity<?> insertVaccineInBatchIntoUser(@PathVariable String userId, @RequestBody List<UsersVaccinesDTO> usersVaccinesDTOList) {
        UserVaccineContext context = UserVaccineContext.builder()
                .userId(userId)
                .usersVaccinesDTOList(usersVaccinesDTOList)
                .build();

        List<UsersVaccines> response = insertVaccinesInBatchIntoUser.execute(context);

        if(response.size() == usersVaccinesDTOList.size()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        if(!response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.PARTIAL_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
