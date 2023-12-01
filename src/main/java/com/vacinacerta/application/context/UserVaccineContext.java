package com.vacinacerta.application.context;

import com.vacinacerta.domain.entities.dto.UsersVaccinesDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserVaccineContext {
    String userId;
    List<UsersVaccinesDTO> usersVaccinesDTOList;
    UsersVaccinesDTO usersVaccinesDTO;
}
