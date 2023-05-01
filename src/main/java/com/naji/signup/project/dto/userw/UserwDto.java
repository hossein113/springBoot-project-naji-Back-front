package com.naji.signup.project.dto.userw;

import com.naji.signup.project.base.dto.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserwDto extends BaseDto<Long> {

    private String firstName;
    private String lastName;
    private String birrthDay;

    private String darege;
    private Float payehoghogh;
    private Float ezafekar;
    private Float maliat;
    private Float sum;
}
