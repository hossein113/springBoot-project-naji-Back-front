package com.naji.signup.project.base.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
public class BaseDto<ID extends Serializable> implements Serializable {

    @Id
    @GeneratedValue
    private ID id;
}
