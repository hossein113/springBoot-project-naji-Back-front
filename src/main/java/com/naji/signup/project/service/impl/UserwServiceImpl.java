package com.naji.signup.project.service.impl;

import com.naji.signup.project.base.service.impl.BaseDtoServiceImpl;
import com.naji.signup.project.domain.Userw;
import com.naji.signup.project.dto.userw.UserwDto;
import com.naji.signup.project.dto.userw.UserwSignUpDto;
import com.naji.signup.project.mapper.UserwMapperEntityToDto;
import com.naji.signup.project.repository.UserwRepository;
import com.naji.signup.project.service.UserwService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;


@Service
@Transactional(readOnly = true)
public class UserwServiceImpl extends BaseDtoServiceImpl<UserwDto,
        Userw,
        Long,
        UserwMapperEntityToDto,
        UserwRepository>
        implements UserwService {


    public UserwServiceImpl(UserwRepository repository, UserwMapperEntityToDto mapper) {
        super(repository, mapper);
    }

    @Override
    @Transactional
    public Boolean mohasebeHoghoogh(UserwSignUpDto userDto) throws SQLIntegrityConstraintViolationException {

        UserwDto user1 = new UserwDto();

        BeanUtils.copyProperties(userDto, user1);

        user1.setFirstName(userDto.getFirstName());
        user1.setLastName(userDto.getLastName());
        user1.setDarege(userDto.getDarege());
        user1.setEzafekar(userDto.getEzafekar() * 5000);
        if (userDto.getDarege().equals("sardar")) {
            user1.setPayehoghogh(10000000F);

        } else if (userDto.getDarege().equals("sarhang")) {
            user1.setPayehoghogh(9000000F);

        } else if (userDto.getDarege().equals("sargord")) {
            user1.setPayehoghogh(8000000F);

        } else if (userDto.getDarege().equals("sotvan")) {
            user1.setPayehoghogh(7000000F);
        }
        user1.setMaliat((float) ((user1.getPayehoghogh() + user1.getEzafekar()) * 0.05));

        user1.setSum((user1.getPayehoghogh() + user1.getEzafekar()) - user1.getMaliat());

        super.save(user1);

        return true;
    }
}