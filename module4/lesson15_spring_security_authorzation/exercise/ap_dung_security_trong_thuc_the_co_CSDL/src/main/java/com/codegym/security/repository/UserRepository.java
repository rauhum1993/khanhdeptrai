package com.codegym.security.repository;

import com.codegym.security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByUserName(String username);
}
