package com.vacinacerta.domain.usecase.usersvaccines;

import com.vacinacerta.application.context.UserVaccineContext;
import com.vacinacerta.domain.entities.db.User;
import com.vacinacerta.domain.entities.db.UsersVaccines;
import com.vacinacerta.domain.entities.db.Vaccine;
import com.vacinacerta.domain.entities.dto.UsersVaccinesDTO;
import com.vacinacerta.domain.entities.mapper.UsersVaccinesMapper;
import com.vacinacerta.domain.repository.IUsersVaccinesRepository;
import com.vacinacerta.domain.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Qualifier("InsertNewUsersVaccine")
public class InsertNewUsersVaccine implements IUseCase<UserVaccineContext, UsersVaccinesDTO> {

    @Autowired
    private final IUsersVaccinesRepository usersVaccinesRepository;

    @Override
    public UsersVaccinesDTO execute(UserVaccineContext context) {
        UsersVaccines usersVaccines = UsersVaccines.builder()
                .user(User.builder().id(context.getUserId()).build())
                .vaccine(Vaccine.builder().id(context.getVaccineId()).build())
                .build();
        
        return UsersVaccinesMapper.convertToUsersVaccinesDTO(usersVaccinesRepository.save(usersVaccines));
    }
}
