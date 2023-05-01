package com.naji.signup.project.repository;


import com.naji.signup.project.Enuneration.Role;
import com.naji.signup.project.Enuneration.Status;
import com.naji.signup.project.base.repository.BaseRepository;
import com.naji.signup.project.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    Long countUserByRole(Role role);

    Long countUserByStatus(Status status);

    List<User> findAllByRole(Role role);

    List<User> findAllByStatus(Status status);

    User findByUsername(String name);

}