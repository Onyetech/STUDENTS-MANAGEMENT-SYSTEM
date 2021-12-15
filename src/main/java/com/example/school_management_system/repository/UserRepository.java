package com.example.school_management_system.repository;

import com.example.school_management_system.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
Users findUsersByEmail(String email);
public boolean existsByEmail(String email);
}
