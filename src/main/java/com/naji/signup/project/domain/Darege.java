package com.naji.signup.project.domain;


import com.naji.signup.project.base.doamain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Darege extends BaseEntity<Long> {


    private String name;

}
