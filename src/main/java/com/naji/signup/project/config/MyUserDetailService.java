package com.naji.signup.project.config;

import com.naji.signup.project.Enuneration.Role;
import com.naji.signup.project.Enuneration.Status;
import com.naji.signup.project.dto.user.UserDto;
import com.naji.signup.project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Qualifier("User")
@Primary
@RequiredArgsConstructor
@Log4j2
public class MyUserDetailService implements UserDetailsService {
    private final UserService userService;

    private UserDto userRequestDTO;

    public UserDto getUserRequestDTO() {
        if (!userRequestDTO.getRole().equals(Role.ADMIN)) {
            throw new UsernameNotFoundException("NOT FOUND USER ... !");
        }
        return userRequestDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        userRequestDTO = userService.findByUsername(username);
        if (userRequestDTO == null || !userRequestDTO.getRole().equals(Role.ADMIN)) {
            throw new UsernameNotFoundException("user not found");
        }
        if (!userRequestDTO.getStatus().equals(Status.ACTIVE)) {
            log.error("user not active");
        }
        return User
                .withUsername(username)
                .password(userRequestDTO.getPassword())
                .authorities("ROLE_".concat(userRequestDTO.getRole().name())
                ).build();
    }
}
