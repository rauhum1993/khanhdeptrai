package com.codegym.security.repository;

import com.codegym.security.entity.AppUser;
import com.codegym.security.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface RoleUserRepository extends JpaRepository<RoleUser, Integer> {

    List<RoleUser> findByUserRole(AppUser appUser);
}
