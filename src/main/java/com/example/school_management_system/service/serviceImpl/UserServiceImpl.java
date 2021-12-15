package com.example.school_management_system.service.serviceImpl;

import com.example.school_management_system.model.Users;
import com.example.school_management_system.repository.UserRepository;
import com.example.school_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public Users findByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public void register(Users users) {
        userRepository.save(users);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
