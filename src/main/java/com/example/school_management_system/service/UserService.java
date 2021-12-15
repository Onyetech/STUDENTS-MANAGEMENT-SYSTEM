package com.example.school_management_system.service;

import com.example.school_management_system.model.Users;

public interface UserService {
    Users findByEmail(String email);
    public void register(Users users);
    public boolean existByEmail(String email);
}
