package com.naji.signup.project.resource;

import com.naji.signup.project.dto.user.UserSignUpDto;
import com.naji.signup.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserResources {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody UserSignUpDto userSignUpDto)
            throws SQLIntegrityConstraintViolationException {
        userService.signUpUserDto(userSignUpDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/sucessfuly")
    public String sucessful() {

        return "sucessfully sign up";
    }
}