package com.naji.signup.project.mapper;


import com.naji.signup.project.base.mapper.BaseMapperEntityToDto;
import com.naji.signup.project.domain.User;
import com.naji.signup.project.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapperEntityToDto extends BaseMapperEntityToDto<User, UserDto, Long> {
}
