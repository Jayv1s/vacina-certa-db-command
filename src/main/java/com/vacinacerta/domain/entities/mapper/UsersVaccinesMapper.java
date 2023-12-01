package com.vacinacerta.domain.entities.mapper;

import com.vacinacerta.domain.entities.db.UsersVaccines;
import com.vacinacerta.domain.entities.dto.UsersVaccinesDTO;

public class UsersVaccinesMapper {
    public static UsersVaccinesDTO convertToUsersVaccinesDTO(UsersVaccines usersVaccines) {
        return UsersVaccinesDTO.builder()
                .vaccineDTO(VaccineMapper.convertToVaccineDTO(usersVaccines.getVaccine()))
                .usersDTO(UserMapper.convertToUsersDTO(usersVaccines.getUser()))
                .id(usersVaccines.getId())
                .appliedAt(usersVaccines.getAppliedAt())
                .build();
    }

    public static UsersVaccines convertToUsersVaccinesDB(UsersVaccinesDTO usersVaccinesDTO) {
        return UsersVaccines.builder()
                .vaccine(VaccineMapper.convertToVaccineDB(usersVaccinesDTO.getVaccineDTO()))
                .user(UserMapper.convertToUserDB(usersVaccinesDTO.getUsersDTO()))
                .id(usersVaccinesDTO.getId())
                .appliedAt(usersVaccinesDTO.getAppliedAt())
                .build();
    }
}
