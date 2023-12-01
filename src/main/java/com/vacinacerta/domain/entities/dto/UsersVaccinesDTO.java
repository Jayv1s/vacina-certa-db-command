package com.vacinacerta.domain.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersVaccinesDTO {
    public String id;
    private UsersDTO usersDTO;
    private VaccineDTO vaccineDTO;
    private Date appliedAt;
}
