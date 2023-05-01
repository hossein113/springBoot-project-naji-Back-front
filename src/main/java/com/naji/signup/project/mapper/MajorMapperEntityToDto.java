package com.naji.signup.project.mapper;


import com.naji.signup.project.base.mapper.BaseMapperEntityToDto;
import com.naji.signup.project.domain.Major;
import com.naji.signup.project.dto.major.MajorDto;
import org.mapstruct.Mapper;

@Mapper
public interface MajorMapperEntityToDto extends BaseMapperEntityToDto<Major, MajorDto, Long> {
}
