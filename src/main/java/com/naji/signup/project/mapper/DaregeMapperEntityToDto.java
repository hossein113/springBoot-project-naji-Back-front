package com.naji.signup.project.mapper;


import com.naji.signup.project.base.mapper.BaseMapperEntityToDto;
import com.naji.signup.project.domain.Darege;
import com.naji.signup.project.dto.darege.DaregeDto;
import org.mapstruct.Mapper;

@Mapper
public interface DaregeMapperEntityToDto extends BaseMapperEntityToDto<Darege, DaregeDto, Long> {
}
