package com.vacinacerta.domain.usecase.usersvaccines;

import com.vacinacerta.application.context.UserVaccineContext;
import com.vacinacerta.domain.entities.db.User;
import com.vacinacerta.domain.entities.db.UsersVaccines;
import com.vacinacerta.domain.entities.db.Vaccine;
import com.vacinacerta.domain.entities.dto.UsersVaccinesDTO;
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
    public List<UsersVaccines> execute(UserVaccineContext context) {
        List<UsersVaccines> usersVaccineList = new ArrayList<>();

        for (UsersVaccinesDTO usersVaccinesDTO : context.getUsersVaccinesDTOList()) {
            UsersVaccines usersVaccine =  UsersVaccines.builder()
                    .user(User.builder().id(context.getUserId()).build())
                    .vaccine(Vaccine.builder().id(usersVaccinesDTO.getVaccineDTO().getId()).build())
                    .appliedAt(usersVaccinesDTO.getAppliedAt())
                    .build();

            usersVaccineList.add(usersVaccine);
        }

        return vaccinesRepository.saveAll(usersVaccineList);
    }
}
