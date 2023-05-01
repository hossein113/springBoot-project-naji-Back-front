package com.naji.signup.project.domain;

import com.naji.signup.project.base.doamain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Userw extends BaseEntity<Long> {


    private String firstName;
    private String lastName;
    private String birrthDay;

    private String darege;
    private Float payehoghogh;
    private Float ezafekar;
    private Float maliat;
    private Float sum;
}

