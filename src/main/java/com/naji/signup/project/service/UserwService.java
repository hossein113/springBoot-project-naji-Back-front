package com.naji.signup.project.service;

import com.naji.signup.project.base.service.BaseDtoService;
import com.naji.signup.project.dto.userw.UserwDto;
import com.naji.signup.project.dto.userw.UserwSignUpDto;

import java.sql.SQLIntegrityConstraintViolationException;

public interface UserwService extends BaseDtoService<UserwDto, Long> {

    Boolean mohasebeHoghoogh(UserwSignUpDto userDto) throws SQLIntegrityConstraintViolationException;

}
