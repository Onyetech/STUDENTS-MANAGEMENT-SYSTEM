package com.example.school_management_system.service.serviceImpl;

import com.example.school_management_system.model.AppUser;
import com.example.school_management_system.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    private AppUser user;

    @BeforeEach
    void setUp() {
        user.setEmail("godsonjonathan39@gmail.com");
        user.setDateOfBirth("02-07-1994");
        user.setFirstName("godson");
        user.setGender("Male");
        user.setLastName("Jonathan");
        user.setPassword("1234");

    }

    @Test
    void findByEmail() {

        //mock userRepository

        when(userRepository.findUsersByEmail(anyString())).thenReturn(user);


        //then call method to be tested

        AppUser findUser = userServiceImpl.findByEmail("243536");

        assertNotNull(findUser);
        assertEquals("godson@jonathan.com", findUser.getEmail());
    }

    @Test
    void register() {


        when(userRepository.save(any(AppUser.class))).thenReturn(user);

        //call method to be tested

        userServiceImpl.register(user);

        //Assertion

        verify(userRepository,times(1)).save(any(AppUser.class));
    }

    @Test
    void existByEmail() {

        when(userRepository.existsByEmail(anyString())).thenReturn(true);

        //then call method to be tested

        boolean ifEmailExist = userServiceImpl.existByEmail("godson@jonathan.com");
        assertNotNull(ifEmailExist);
    }
}