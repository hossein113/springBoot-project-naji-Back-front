package com.naji.signup.project.service.impl;


import com.naji.signup.project.base.service.impl.BaseDtoServiceImpl;
import com.naji.signup.project.domain.Darege;
import com.naji.signup.project.dto.darege.DaregeDto;
import com.naji.signup.project.mapper.DaregeMapperEntityToDto;
import com.naji.signup.project.repository.DarageRepository;
import com.naji.signup.project.service.DaregeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DaregeServiceImpl extends BaseDtoServiceImpl<DaregeDto,
        Darege,
        Long,
        DaregeMapperEntityToDto,
        DarageRepository>
        implements DaregeService {


    public DaregeServiceImpl(DarageRepository repository, DaregeMapperEntityToDto mapper) {
        super(repository, mapper);
    }
}
