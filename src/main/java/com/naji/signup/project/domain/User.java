package com.naji.signup.project.domain;


import com.naji.signup.project.Enuneration.Gender;
import com.naji.signup.project.Enuneration.Role;
import com.naji.signup.project.Enuneration.Status;
import com.naji.signup.project.base.doamain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class User extends BaseEntity<Long> {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String password;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Major major;
}
