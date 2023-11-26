package com.vacinacerta.domain.entities.mapper;


import com.vacinacerta.domain.entities.db.User;
import com.vacinacerta.domain.entities.dto.UsersDTO;
import com.vacinacerta.domain.enums.DocumentsType;

public class UserMapper {
    public static UsersDTO convertToUsersDTO(User user) {
        return UsersDTO.builder()
                .id(user.getId())
                .createdAt(user.getCreatedAt())
                .dateOfBirth(user.getDateOfBirth())
                .document(user.getDocument())
                .documentType(DocumentsType.valueOf(user.getDocumentType()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .updatedAt(user.getUpdatedAt())
                .phone(user.getPhone())
                .nickname(user.getNickname())
                .build();
    }

    public static User convertToUserDB(UsersDTO user) {
        return User.builder()
                .id(user.getId())
                .createdAt(user.getCreatedAt())
                .dateOfBirth(user.getDateOfBirth())
                .document(user.getDocument())
                .documentType(user.getDocumentType().name())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .updatedAt(user.getUpdatedAt())
                .phone(user.getPhone())
                .nickname(user.getNickname())
                .build();
    }
}
