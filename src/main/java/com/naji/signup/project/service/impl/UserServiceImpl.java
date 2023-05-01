package com.naji.signup.project.service.impl;


import com.naji.signup.project.Enuneration.Gender;
import com.naji.signup.project.Enuneration.Role;
import com.naji.signup.project.Enuneration.Status;
import com.naji.signup.project.base.service.impl.BaseDtoServiceImpl;
import com.naji.signup.project.domain.Major;
import com.naji.signup.project.domain.User;
import com.naji.signup.project.dto.user.UserDto;
import com.naji.signup.project.dto.user.UserResponseDto;
import com.naji.signup.project.dto.user.UserSearchDto;
import com.naji.signup.project.dto.user.UserSignUpDto;
import com.naji.signup.project.mapper.UserMapperDtoResponseToDto;
import com.naji.signup.project.mapper.UserMapperEntityToDto;
import com.naji.signup.project.repository.UserRepository;
import com.naji.signup.project.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseDtoServiceImpl<UserDto,
        User,
        Long,
        UserMapperEntityToDto,
        UserRepository>
        implements UserService {

    @Autowired
    private UserMapperDtoResponseToDto userMapperResponseDtoWithDto;

    public UserServiceImpl(UserRepository repository, UserMapperEntityToDto mapper) {
        super(repository, mapper);
    }

    @Override
    @Transactional
    public Boolean signUpUserDto(@Valid UserSignUpDto signUpUserDto) throws SQLIntegrityConstraintViolationException {

        UserDto userRequestDTO = new UserDto();
        userRequestDTO.setStatus(Status.PENDING);
        BeanUtils.copyProperties(signUpUserDto, userRequestDTO);

        super.save(userRequestDTO);
        return true;
    }


    @Override
    public Long countUserByRole(Role role) {
        return repository.countUserByRole(role);
    }

    @Override
    public Long countUserByStatus(Status status) {
        return repository.countUserByStatus(status);
    }

    @Override
    public List<UserResponseDto> findAllResponse() {
        List<User> listUsers = repository.findAll();
        List<UserDto> userDtosList = mapper.convertListEntityToDto(listUsers);
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        userDtosList.forEach(data -> {
            UserResponseDto userResponseDto = new UserResponseDto();
            BeanUtils.copyProperties(data, userResponseDto);
            userResponseDtoList.add(userResponseDto);
        });

        return userResponseDtoList;
    }

    @Override
    public List<UserResponseDto> findAllByRole(Role role) {
        List<User> userList = repository.findAllByRole(role);
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();

        List<UserDto> userDtosList = mapper.convertListEntityToDto(userList);
        userDtosList.forEach(data -> {

                    UserResponseDto userResponseDto = new UserResponseDto();
                    BeanUtils.copyProperties(data, userResponseDto);
                    userResponseDtoList.add(userResponseDto);
                }
        );

        return userResponseDtoList;
    }

    @Override
    public List<UserResponseDto> findAllByStatus(Status status) {
        List<User> userList = repository.findAllByStatus(status);
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        userList.forEach(data -> {

                    UserResponseDto userResponseDto = new UserResponseDto();
                    BeanUtils.copyProperties(data, userResponseDto);
                    userResponseDtoList.add(userResponseDto);
                }
        );

        return userResponseDtoList;

    }

    @Override
    @Transactional
    public Boolean activeStatus(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            user.get().setStatus(Status.ACTIVE);
            repository.save(user.get());

        }
        return true;
    }

    @Override
    @Transactional
    public Boolean rejectStatus(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            user.get().setStatus(Status.REJECTION);
            repository.save(user.get());

        }
        return true;
    }

    @Override
    public Boolean changeStatusUser(Long id, Role role) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            if (role.name().equals("ACTIVE")) {
                user.get().setStatus(Status.ACTIVE);
            } else {
                user.get().setStatus(Status.REJECTION);
            }
            repository.save(user.get());
        }
        return true;

    }

    @Override
    public UserDto findByUsername(String username) {
        return mapper.convertEntityToDto(repository.findByUsername(username));
    }


    @Override
    public List<UserResponseDto> AllByAdvanceSearch(UserSearchDto userSearchDto) {

        Pageable paging = PageRequest.of(userSearchDto.getPageNumber(),
                userSearchDto.getPageSize(), Sort.by(userSearchDto.getSortBy()));

        Page<User> all = repository.findAll(
                (root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    setNotRolePredicate(predicates, root, criteriaBuilder, Role.ADMIN);
                    setFirstNamePredicate(predicates, root, criteriaBuilder, userSearchDto.getFirstName());
                    setLastNamePredicate(predicates, root, criteriaBuilder, userSearchDto.getLastName());
                    setGenderPredicate(predicates, root, criteriaBuilder, userSearchDto.getGender());
                    setRolePredicate(predicates, root, criteriaBuilder, userSearchDto.getRole());
                    setStatusPredicate(predicates, root, criteriaBuilder, userSearchDto.getStatus());
                    setMajorPredicate(predicates, root, criteriaBuilder, userSearchDto.getMajor());
                    return criteriaBuilder.and(
                            predicates.toArray(new Predicate[0])
                    );
                }
                , paging);

        if (all.hasContent()) {
            List<User> content = all.getContent();
            List<UserResponseDto> userResponseDtos = new ArrayList<>();

            List<UserDto> userDtos = mapper.convertListEntityToDto(content);
            userDtos.forEach(userDto -> {
                UserResponseDto userResponse = new UserResponseDto();
                BeanUtils.copyProperties(userDto, userResponse);
                userResponseDtos.add(userResponse);
            });

            return userResponseDtos;
        }
        throw new BadCredentialsException("user not found with your search content");
    }


    private void setFirstNamePredicate(List<Predicate> predicates, Root<User> root,
                                       CriteriaBuilder criteriaBuilder, String name) {
        if (name != null && !name.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("firstName"),
                            "%" + name + "%"
                    )
            );
        }
    }


    private void setNotRolePredicate(List<Predicate> predicates, Root<User> root,
                                     CriteriaBuilder criteriaBuilder, Role role) {
        predicates.add(
                criteriaBuilder.notEqual(
                        root.get("role"),
                        role
                )
        );
    }


    private void setLastNamePredicate(List<Predicate> predicates, Root<User> root,
                                      CriteriaBuilder criteriaBuilder, String name) {
        if (StringUtils.hasText(name)) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("lastName"),
                            "%" + name + "%"
                    )
            );
        }
    }

    private void setStatusPredicate(List<Predicate> predicates, Root<User> root
            , CriteriaBuilder criteriaBuilder, Status status) {
        if (status != null && StringUtils.hasText(status.name())) {
            predicates.add(
                    criteriaBuilder.equal(
                            root.get("status"),
                            status
                    )
            );
        }
    }

    private void setRolePredicate(List<Predicate> predicates, Root<User> root,
                                  CriteriaBuilder criteriaBuilder, Role role) {
        if (role != null && StringUtils.hasText(role.name())) {
            predicates.add(
                    criteriaBuilder.equal(
                            root.get("role"),
                            role
                    )
            );
        }
    }

    private void setMajorPredicate(List<Predicate> predicates, Root<User> root,
                                   CriteriaBuilder criteriaBuilder, Major major) {
        if (major != null) {
            predicates.add(
                    criteriaBuilder.equal(
                            root.get("major"),
                            major.getId()
                    )
            );
        }


    }


    private void setGenderPredicate(List<Predicate> predicates, Root<User> root,
                                    CriteriaBuilder criteriaBuilder, Gender gender) {
        if (gender != null && StringUtils.hasText(gender.name())) {
            predicates.add(
                    criteriaBuilder.equal(
                            root.get("gender"),
                            gender
                    )
            );
        }


    }


}