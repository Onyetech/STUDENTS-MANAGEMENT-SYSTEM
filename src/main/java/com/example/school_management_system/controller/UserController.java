package com.example.school_management_system.controller;

import com.example.school_management_system.model.AppUser;
import com.example.school_management_system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model){

        AppUser users = new AppUser();
        model.addAttribute("users",users);
        return "login";
    }

    @PostMapping("/register")
    public String signUp(@ModelAttribute("users") AppUser users, HttpSession httpSession){
        System.out.println("29");
        AppUser checkUser = userService.findByEmail(users.getEmail());
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

        AppUser users = new AppUser();
        model.addAttribute("users",users);
        return "studentportallogin";
    }

    @GetMapping("/add_student")
    public String addStudent(Model model){

        AppUser users = new AppUser();
        model.addAttribute("users",users);
        return "dashboard";
    }

    @PostMapping("/login")
    public String login(/*HttpServletRequest request,*/ @ModelAttribute("users") AppUser users, HttpSession session){

        System.out.println(users);

        AppUser user1 = new AppUser();
//        session = request.getSession();
//        session.setAttribute("users", user1);

        System.out.println("session "+user1);
        AppUser checkUser = userService.findByEmail(users.getEmail());
        System.out.println(checkUser.getPassword());
        System.out.println(checkUser);
        if(checkUser.getPassword().equals(users.getPassword())){
            session.setAttribute("users", checkUser);
            return "dashboard";
        }
        else {
            return "error";
        }
    }

//    try {
//        User checkUser = userService.findByEmail(user.getEmail());
//        if(checkUser.getPassword().equals(user.getPassword()) ){
//            session.setAttribute("user", checkUser);
//        }
//    }catch(Exception ex){
//        return "redirect:/";
//    }
//        return "redirect:/home";

}
