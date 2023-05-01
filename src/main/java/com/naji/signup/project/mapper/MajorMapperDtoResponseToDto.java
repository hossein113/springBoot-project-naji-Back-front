package com.naji.signup.project.mapper;


import com.naji.signup.project.base.mapper.BaseMapperDtoToDto;
import com.naji.signup.project.dto.major.MajorDto;
import com.naji.signup.project.dto.major.MajorResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface MajorMapperDtoResponseToDto extends BaseMapperDtoToDto<MajorResponseDto, MajorDto> {
}
