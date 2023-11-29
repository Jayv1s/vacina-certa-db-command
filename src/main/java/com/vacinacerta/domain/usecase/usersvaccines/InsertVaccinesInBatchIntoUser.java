package com.vacinacerta.domain.usecase.usersvaccines;

import com.vacinacerta.application.context.UserVaccineContext;
import com.vacinacerta.domain.entities.db.User;
import com.vacinacerta.domain.entities.db.UsersVaccines;
import com.vacinacerta.domain.entities.db.Vaccine;
import com.vacinacerta.domain.repository.IUsersVaccinesRepository;
import com.vacinacerta.domain.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("InsertVaccinesInBatchIntoUser")
@AllArgsConstructor
public class InsertVaccinesInBatchIntoUser implements IUseCase<UserVaccineContext, List<UsersVaccines>> {

    @Autowired
    private IUsersVaccinesRepository vaccinesRepository;

    @Override
    public List<UsersVaccines> execute(UserVaccineContext userVaccineContext) {
        List<UsersVaccines> usersVaccineList = new ArrayList<>();

        for (String vaccineID : userVaccineContext.getVaccineIds()) {
            UsersVaccines usersVaccine =  UsersVaccines.builder()
                    .user(User.builder().id(userVaccineContext.getUserId()).build())
                    .vaccine(Vaccine.builder().id(vaccineID).build())
                    .build();

            usersVaccineList.add(usersVaccine);
        }

        return vaccinesRepository.saveAll(usersVaccineList);
    }
}
