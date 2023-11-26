package com.vacinacerta.infraestructure;

import com.vacinacerta.domain.entities.db.UserAccess;
import com.vacinacerta.domain.repository.IUserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserAccessRepository userAccessRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserAccess userAccess = userAccessRepository.findById(login).orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));

        String[] roles = userAccess.getRoles().split(",");

        return User.builder()
                .username(userAccess.getLogin())
                .password(userAccess.getPassword())
                .roles(roles)
                .build();
    }
}
