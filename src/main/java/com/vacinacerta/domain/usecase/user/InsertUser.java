package com.vacinacerta.domain.usecase.user;

import com.entities.db.User;
import com.entities.dto.UsersDTO;
import com.entities.mapper.UserMapper;
import com.vacinacerta.domain.repository.IUserRepository;
import com.vacinacerta.domain.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Qualifier("InsertUser")
public class InsertUser implements IUseCase<UsersDTO, String> {

    @Autowired
    private final IUserRepository userRepository;

    @Override
    public String execute(UsersDTO userDTO) {
        User userDB = UserMapper.convertToUserDB(userDTO);
        userDB.setCreatedAt(LocalDateTime.now());
        userDB.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(userDB).getId();
    }
}
