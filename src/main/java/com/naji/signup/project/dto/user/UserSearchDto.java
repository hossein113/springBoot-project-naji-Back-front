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

@Getter
@Setter
@NoArgsConstructor
public class UserSearchDto {
    Integer pageNumber;
    Integer pageSize;
    String sortBy;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Major major;

}
