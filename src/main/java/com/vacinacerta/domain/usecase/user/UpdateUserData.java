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
@Qualifier("UpdateUserData")
public class UpdateUserData implements IUseCase<UsersDTO, UsersDTO> {

    @Autowired
    private final IUserRepository userRepository;

    @Override
    public UsersDTO execute(UsersDTO userDTO) {
        User userDB = UserMapper.convertToUserDB(userDTO);
        userDB.setUpdatedAt(LocalDateTime.now());

        User response = userRepository.save(userDB);

        return UserMapper.convertToUsersDTO(response);
    }
}
