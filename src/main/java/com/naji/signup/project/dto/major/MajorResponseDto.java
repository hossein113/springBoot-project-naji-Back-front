package com.naji.signup.project.dto.major;


import com.naji.signup.project.base.dto.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MajorResponseDto extends BaseDto<Long> {

    private String name;
}
