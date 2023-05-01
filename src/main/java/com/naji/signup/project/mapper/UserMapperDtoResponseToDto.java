package com.naji.signup.project.mapper;


import com.naji.signup.project.base.mapper.BaseMapperDtoToDto;
import com.naji.signup.project.dto.user.UserDto;
import com.naji.signup.project.dto.user.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapperDtoResponseToDto extends BaseMapperDtoToDto<UserResponseDto, UserDto> {
}
