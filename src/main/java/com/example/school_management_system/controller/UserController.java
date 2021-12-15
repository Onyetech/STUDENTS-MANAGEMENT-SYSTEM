package com.example.school_management_system.controller;

import com.example.school_management_system.model.Users;
import com.example.school_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model){

        Users users = new Users();
        model.addAttribute("users",users);
        return "login";
    }

    @PostMapping("/register")
    public String signUp(@ModelAttribute("users") Users users, HttpSession httpSession){
        System.out.println("29");
        Users checkUser = userService.findByEmail(users.getEmail());
        System.out.println("31");
        if(userService.existByEmail(users.getEmail())){
            System.out.println("40");
            return "redirect:/home";
//            return "home";
        }

        else {
            System.out.println("38");
            userService.register(users);
            httpSession.setAttribute("users", checkUser);
            System.out.println("41");
            return "redirect:/login";
        }

    }

    @GetMapping("/register")
    public String register(Model model){

        Users users = new Users();
        model.addAttribute("users",users);
        return "studentportallogin";
    }

    @PostMapping("/login")
    public String login(Users users, HttpSession session){

        Users checkUser = userService.findByEmail(users.getEmail());
        if(checkUser.getPassword().equals(users.getPassword())){
            session.setAttribute("users", checkUser);
            return "studentportallogin";
        }
        else {
            return "error";
        }
    }


}
