package com.naji.signup.project.service.impl;


import com.naji.signup.project.base.service.impl.BaseDtoServiceImpl;
import com.naji.signup.project.domain.Major;
import com.naji.signup.project.dto.major.MajorDto;
import com.naji.signup.project.mapper.MajorMapperEntityToDto;
import com.naji.signup.project.repository.MajorRepository;
import com.naji.signup.project.service.MajorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MajorServiceImpl extends BaseDtoServiceImpl<MajorDto,
        Major,
        Long,
        MajorMapperEntityToDto,
        MajorRepository>
        implements MajorService {

    public MajorServiceImpl(MajorRepository repository, MajorMapperEntityToDto mapper) {
        super(repository, mapper);
    }


}
