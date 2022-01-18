package com.example.school_management_system.repository;

import com.example.school_management_system.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
AppUser findUsersByEmail(String email);
public boolean existsByEmail(String email);
}
