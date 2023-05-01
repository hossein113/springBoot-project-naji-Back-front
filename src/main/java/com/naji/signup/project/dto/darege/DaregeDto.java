package com.naji.signup.project.dto.darege;

import com.naji.signup.project.base.dto.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DaregeDto extends BaseDto<Long> {
    private String name;
}
