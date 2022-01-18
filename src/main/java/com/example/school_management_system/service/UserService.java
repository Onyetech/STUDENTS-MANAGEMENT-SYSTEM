package com.example.school_management_system.service;

import com.example.school_management_system.model.AppUser;

public interface UserService {
    AppUser findByEmail(String email);
    public void register(AppUser users);
    public boolean existByEmail(String email);
}
