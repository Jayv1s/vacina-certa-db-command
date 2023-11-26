package com.vacinacerta.domain.entities.dto;


import com.vacinacerta.domain.entities.db.User;
import com.vacinacerta.domain.entities.db.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersVaccinesDTO {
    public String id;
    private User user;
    private Vaccine vaccine;
}
