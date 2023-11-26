package com.vacinacerta.domain.usecase.usersvaccines;

import com.vacinacerta.domain.entities.db.UsersVaccines;
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
public class InsertNewUsersVaccine implements IUseCase<UsersVaccinesDTO, UsersVaccinesDTO> {

    @Autowired
    private final IUsersVaccinesRepository usersVaccinesRepository;

    @Override
    public UsersVaccinesDTO execute(UsersVaccinesDTO usersVaccinesDTO) {
        UsersVaccines usersVaccines = UsersVaccinesMapper.convertToUsersVaccines(usersVaccinesDTO);
        return UsersVaccinesMapper.convertToUsersVaccinesDTO(usersVaccinesRepository.save(usersVaccines));
    }
}
