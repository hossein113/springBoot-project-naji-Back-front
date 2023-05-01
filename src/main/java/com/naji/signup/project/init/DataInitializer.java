package com.naji.signup.project.init;

import com.naji.signup.project.Enuneration.Gender;
import com.naji.signup.project.Enuneration.Role;
import com.naji.signup.project.Enuneration.Status;
import com.naji.signup.project.dto.user.UserDto;
import com.naji.signup.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.SQLIntegrityConstraintViolationException;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() throws SQLIntegrityConstraintViolationException {
        initUsers();
    }

    private void initUsers() throws SQLIntegrityConstraintViolationException {
        if (userService.count() == 0) {
            UserDto userDto = new UserDto();
            userDto.setFirstName("hossein");
            userDto.setLastName("marj");
            userDto.setPassword(passwordEncoder.encode("123"));
            userDto.setRole(Role.ADMIN);

            userDto.setGender(Gender.MALE);
            userDto.setStatus(Status.ACTIVE);
            userService.save(userDto);

        }
    }


}
