package com.naji.signup.project.service;


import com.naji.signup.project.Enuneration.Role;
import com.naji.signup.project.Enuneration.Status;
import com.naji.signup.project.base.service.BaseDtoService;
import com.naji.signup.project.dto.user.UserDto;
import com.naji.signup.project.dto.user.UserResponseDto;
import com.naji.signup.project.dto.user.UserSearchDto;
import com.naji.signup.project.dto.user.UserSignUpDto;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface UserService extends BaseDtoService<UserDto, Long> {

    Boolean signUpUserDto(UserSignUpDto userSignUpDto) throws SQLIntegrityConstraintViolationException;

    Long countUserByRole(Role role);

    Long countUserByStatus(Status status);

    List<UserResponseDto> findAllResponse();

    List<UserResponseDto> findAllByRole(Role role);

    List<UserResponseDto> findAllByStatus(Status status);

    Boolean activeStatus(Long id);

    Boolean rejectStatus(Long id);

    Boolean changeStatusUser(Long id, Role role);

    List<UserResponseDto> AllByAdvanceSearch(UserSearchDto userSearchDto);

    UserDto findByUsername(String username);

}
