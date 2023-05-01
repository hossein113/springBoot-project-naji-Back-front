package com.naji.signup.project.resource;


import com.naji.signup.project.dto.userw.UserwSignUpDto;
import com.naji.signup.project.service.UserwService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/userw")
public class UserwResource {

    private final UserwService userService;


    @PreAuthorize(value = "permitAll()")
    @PostMapping("/sign-up")


    public ResponseEntity signUp(@RequestBody UserwSignUpDto userwDto)
            throws SQLIntegrityConstraintViolationException {
        userService.mohasebeHoghoogh(userwDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
