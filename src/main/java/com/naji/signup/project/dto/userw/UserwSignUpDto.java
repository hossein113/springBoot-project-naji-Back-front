package com.naji.signup.project.dto.userw;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserwSignUpDto {

    @NotBlank(message = "first name can not blank")
    private String firstName;

    @NotBlank(message = "last name can not blank")
    private String lastName;

    private Float ezafekar;

    private String darege;
}
