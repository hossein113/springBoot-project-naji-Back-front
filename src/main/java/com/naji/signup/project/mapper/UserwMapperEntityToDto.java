package com.naji.signup.project.mapper;


import com.naji.signup.project.base.mapper.BaseMapperEntityToDto;
import com.naji.signup.project.domain.Userw;
import com.naji.signup.project.dto.userw.UserwDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserwMapperEntityToDto extends BaseMapperEntityToDto<Userw, UserwDto, Long> {
}
