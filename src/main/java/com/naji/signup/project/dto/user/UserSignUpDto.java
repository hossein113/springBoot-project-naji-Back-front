package com.naji.signup.project.dto.user;


import com.naji.signup.project.Enuneration.Gender;
import com.naji.signup.project.Enuneration.Role;
import com.naji.signup.project.Enuneration.Status;
import com.naji.signup.project.domain.Major;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserSignUpDto {

    @NotBlank(message = "first name can not blank")
    private String firstName;

    @NotBlank(message = "last name can not blank")
    private String lastName;

    @NotNull(message = "gender can not blank")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "role name can not blank")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Major major;
}
